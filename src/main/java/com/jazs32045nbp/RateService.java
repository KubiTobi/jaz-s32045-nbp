package com.jazs32045nbp;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.naming.LimitExceededException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class RateService {

    RestTemplate restTemplate;
    RateQueryResultRepository rateQueryResultRepository;
    public RateService(RestTemplate restTemplate, RateQueryResultRepository rateQueryResultRepository) {
        this.restTemplate = restTemplate;
        this.rateQueryResultRepository = rateQueryResultRepository;
    }

    public ResponseEntity<RateQueryResult> getRate(String start, String end, String currency) throws LimitExceededException {
        try {
            ResponseEntity<RatesResponse> response = restTemplate.exchange("https://api.nbp.pl/api/exchangerates/rates/A/" + currency + "/" + start + "/" + end, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
            });
            Double avg = response.getBody().getRates().stream()
                    .mapToDouble(RatesResponse.Rate::getMid)
                    .average()
                    .orElse(0.0);
            RateQueryResult result = new RateQueryResult(currency, avg, LocalDate.parse(start), LocalDate.parse(end), LocalDateTime.now());
            rateQueryResultRepository.save(result);
            return ResponseEntity.ok(result);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                String body = e.getResponseBodyAsString();
                if (body.contains("Przekroczony limit")) {
                    throw new LimitExceededException("Przekroczony limit");
                }
            } else if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
}

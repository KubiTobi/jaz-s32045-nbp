package com.jazs32045nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.LimitExceededException;

@RestController
public class RateController {

    RateService rateService;
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }
    @Operation(summary = "Return currency rate for period start-end",
            method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rate returned"),
            @ApiResponse(responseCode = "404", description = "Badly constructed query"),
            @ApiResponse(responseCode = "400", description = "Bad data"),
    })
    @GetMapping("/{start}/{end}/{currency}")
    public ResponseEntity<RateQueryResult> getRate(@PathVariable String start, @PathVariable String end, @PathVariable String currency) throws LimitExceededException {
        return rateService.getRate(start, end, currency);
    }
}

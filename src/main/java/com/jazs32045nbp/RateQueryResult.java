package com.jazs32045nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Schema(description = "Represents a returned rates result.")
public class RateQueryResult {

    @Id
    @GeneratedValue
    @Schema(description = "Unique identifier of the result", example = "1")
    private Long id;

    @Schema(description = "Currency code or name (e.g., USD, EUR)", example = "USD")
    private String currency;

    @Schema(description = "Average exchange rate in the given date range", example = "4.1234")
    private Double rate;

    @Schema(description = "Start date of the requested range", example = "2025-01-01")
    private LocalDate start;

    @Schema(description = "End date of the requested range", example = "2025-01-10")
    private LocalDate end;

    @Schema(description = "Date and time when this result was created", example = "2025-06-21T14:33:00")
    private LocalDateTime date;
    public RateQueryResult(String currency, Double rate, LocalDate start, LocalDate end, LocalDateTime date) {
        this.currency = currency;
        this.rate = rate;
        this.start = start;
        this.end = end;
        this.date = date;
    }

    public RateQueryResult() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

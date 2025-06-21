package com.jazs32045nbp;

import java.util.List;

public class RatesResponse {
    private List<Rate> rates;

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public static class Rate {
        private double mid;

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }
    }
}

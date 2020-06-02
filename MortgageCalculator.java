package com.codewithpimenova;

public class MortgageCalculator {
    private final static byte  PERCENT = 100;
    private final static short  MONTHS_IN_YEAR = 12;

    private int principal;
    private byte years;
    private float annualInterest;

    public MortgageCalculator(int principal, byte years, float annualInterest) {
        this.principal = principal;
        this.years = years;
        this.annualInterest = annualInterest;
    }


    public double mortgageCalculate(){
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = (short)(getNumberOfPayments());


         double mortgage = principal*(monthlyInterest*Math.pow(1 + monthlyInterest, numberOfPayments))/(
                 (Math.pow(1 + monthlyInterest, numberOfPayments) - 1)
                 );

        return mortgage;
    }


 public double balanceCalculate(short numberOfPaymentsMade){
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = (short)getNumberOfPayments();

             double balanceRemaining = ((int)principal*(Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                     /((Math.pow(1 + monthlyInterest, numberOfPayments) - 1)
                         ));
            return balanceRemaining;

        }


    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = balanceCalculate(month);

        return balances;

    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}

package com.codewithpimenova;

public class Main {

    public static void main(String[] args){
        int principal = (int) Console.getNumber("Principal: ", 1_000, 1_000_000);
        byte years = (byte) Console.getNumber("Years: ", 1, 30);
        float annualInterest = (float) Console.getNumber("Annual Interest: ", 1, 30);

        var calculator = new MortgageCalculator(principal, years, annualInterest);
        var report = new MortgageReport(calculator);

        report.printMonthlyMortgage();
        report.printPaymentSchedule();
    }


}







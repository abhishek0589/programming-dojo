package com.abhishek.dojo.misc;

public class IntegerToWords {
    
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final String[] ONE_TO_NINE = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    private static final String[] ELEVEN_TO_NINETEEN = {"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private static final String[] TENS = {"Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    
    public static void main(String[] args) {
    	IntegerToWords i = new IntegerToWords();
    	System.out.println(i.numberToWords(1234567891));
	}
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        
        StringBuilder sb = new StringBuilder();
        
        int slice = num / BILLION;
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice) + "Billion ");
        
        slice = num % BILLION / MILLION;
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice) + "Million ");
        
        slice = num % MILLION / THOUSAND;
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice) + "Thousand ");
        
        slice = num % THOUSAND;
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice));
        
        return sb.toString().trim();
    }
    
    
    private String getWordsForPositiveThreeDigit(int num) {
        if(num>THOUSAND || num==0) return null;
        
        StringBuilder sb = new StringBuilder();
        
        // 343 or 340
        int hundreds = num/HUNDRED;
        if(hundreds>0) sb.append(ONE_TO_NINE[hundreds-1] + "Hundred "); // will always be single digit
        
        int tens = num % HUNDRED / TEN;
        int ones = num % TEN;
        if(tens == 1 && ones>0) { // numbers in range of 11-19
            sb.append(ELEVEN_TO_NINETEEN[ones-1]);
        } else {
            if(tens>0) sb.append(TENS[tens-1]); //numbers between 1-10 and 20-99
            if(ones>0) sb.append(ONE_TO_NINE[ones-1]);//numbers between 1-10 and 20-99 + //numbers between 1-10 and 11-19
        }
        
        return sb.toString();
    }
    
}

package com.progressoft.samples;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class Money {
    //initializing objects from Money class to represent Coins and Bills
    public static final Money Zero = new Money(0);
    public static final Money OnePiaster = new Money(0.01);
    public static final Money FivePiasters = new Money(0.05);
    public static final Money TenPiasters = new Money(0.1);
    public static final Money TwentyFivePiasters = new Money(0.25);
    public static final Money FiftyPiasters = new Money(0.5);
    public static final Money OneDinar = new Money(1.0);
    public static final Money FiveDinars = new Money(5.0);
    public static final Money TenDinars = new Money(10.0);
    public static final Money TwentyDinars = new Money(20.0);
    public static final Money FiftyDinars = new Money(50.0);

    protected final double amount; //to hold total amount

    public final double orignal; //to hold original amount


    /*Frequency array
    // Create a HashMap to store frequency of each Money object
    static Map<Money, Integer> frequencyMap = new HashMap<>();

    // Initialize the frequency map with zeros
    static {
        frequencyMap.put(Zero, 0);
        frequencyMap.put(OnePiaster, 0);
        frequencyMap.put(FivePiasters, 0);
        frequencyMap.put(TenPiasters, 0);
        frequencyMap.put(TwentyFivePiasters, 0);
        frequencyMap.put(FiftyPiasters, 0);
        frequencyMap.put(OneDinar, 0);
        frequencyMap.put(FiveDinars, 0);
        frequencyMap.put(TenDinars, 0);
        frequencyMap.put(TwentyDinars, 0);
        frequencyMap.put(FiftyDinars, 0);

    }

 */
    protected Money(double amount) { //constructor
        this.amount = amount;
        this.orignal = this.amount;

    }

    public double amount() { //getter method
        return amount;
    }

    public Money times(int count) {
        if (count < 0) throw new IllegalArgumentException("Count cannot be negative");
        return new Money(amount * count);
    }

    public static Money sum(Money... items) {
        double total = 0.0;
        for (Money item : items) {
            total += item.amount();
        }
        return new Money(total);
    }

    public Money plus(Money other) {
        return new Money(amount + other.amount());
    }

    public Money minus(Money other) {
        if (this.orignal == this.amount) { //comparing original with possible changed total
            double result = amount - other.amount();//
            if (result < 0) throw new IllegalArgumentException("Result cannot be negative");
            return new Money(result);
        } else {
            throw new IllegalArgumentException("no Change available");
        }

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return Double.compare(money.amount, amount) == 0;
    }

    @Override
    public String toString() {
        return new DecimalFormat("0.00").format(amount);
    }
}

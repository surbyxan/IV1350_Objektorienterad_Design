package com.app.integration;

/**
 * This interface specifies common methods 
 * different types of discounts should implement.
 */
public interface Discount {

    /**
     * Invoked to get the value of a discount type.
     *
     * @return Either percentage or value that should be reduced from
     *         the sale's total price.
     */
    public double getDiscount();
}

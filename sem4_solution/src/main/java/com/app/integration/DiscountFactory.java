package com.app.integration;

/**
 * A singleton discount factory that can create instances of the 
 * three discount classes and return them using the interface {@code Discount}.
 */
public class DiscountFactory {

    private static final DiscountFactory FACTORY = new DiscountFactory();

    private DiscountFactory(){

    }

    /**
     * @return The only instance of this singleton factory.
     */
    public static DiscountFactory getFactory() {
        return FACTORY;
    }

    /**
     * Creates and returns a new discount of specified type using
     * the {@code Discount} interface.
     * 
     * @return The specified discount type with the desired value.
     */
    public Discount newDiscount(DiscountType type, double value) {
        switch (type) {
            case CustomerDiscount:
                return new CustomerDiscount(value);
            case ItemDiscount:
                return new ItemDiscount(value);
            case PriceDiscount:
                return new PriceDiscount(value);
            default:
                return null;
                
        }
    }

    /**
     * Discount types that can be created by the factory
     */
    public enum DiscountType {
        CustomerDiscount,
        ItemDiscount,
        PriceDiscount
    }
}

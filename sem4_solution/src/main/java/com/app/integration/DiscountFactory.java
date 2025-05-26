package com.app.integration;

    
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

    public Discount newDiscount(DiscountType type, double value) {
        switch (type) {
            case CustomerDiscount:
                return new CustomerDiscount(value);
                break;
            case ItemDiscount:
                return new ItemDiscount(value);
                break;
            default:
            case PriceDiscount:
                return new PriceDiscount(value);
                break;
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

package com.app.integration;

    
public class DiscountFactory {
    public enum DiscountType {
        
        
    CUSTustomerD,



    private static final DiscountFactory FACTORY = new DiscountFactory();

    private DiscountFactory(){

    }

    /**
     * @return The only instance of this singleton factory.
     */
    public static DiscountFactory getFactory() {
        return FACTORY;
    }
}
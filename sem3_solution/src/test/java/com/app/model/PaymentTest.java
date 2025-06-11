package com.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void testConstructorInitializesTotalPriceAndDefaults() {
        Payment payment = new Payment(100.0);

        assertEquals(100.0, payment.getTotalPrice(), 0.001);
        assertEquals(0.0, payment.getAmountPaid(), 0.001);
        assertEquals(0.0, payment.getChangeBack(), 0.001);
    }

    @Test
    void testSetAmountPaid() {
        Payment payment = new Payment(50.0);
        double changeBack = payment.setAmountPaid(60.0);

        assertEquals(60.0, payment.getAmountPaid(), 0.001);
        assertEquals(10.0, changeBack, 0.001);
    }

    @Test
    void testSetChangeBack() {
        Payment payment = new Payment(80.0);
        payment.setChangeBack(20.0);

        assertEquals(20.0, payment.getChangeBack(), 0.001);
    }

    // @Test
    // void testMultipleFieldUpdates() {
    //     Payment payment = new Payment(120.0);
    //     payment.setAmountPaid(150.0);
    //     payment.setChangeBack(30.0);

    //     assertEquals(120.0, payment.getTotalPrice(), 0.001);
    //     assertEquals(150.0, payment.getAmountPaid(), 0.001);
    //     assertEquals(30.0, payment.getChangeBack(), 0.001);
    // }
}

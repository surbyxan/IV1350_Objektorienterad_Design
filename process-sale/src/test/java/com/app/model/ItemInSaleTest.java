package com.app.model;

import com.app.integration.*;
import com.app.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ItemInSaleTest {
    
    ItemInSale item;
    ItemDTO itemDTO;

    @BeforeEach
    void setup() {
        itemDTO = new ItemDTO(1, "Description", 10.0, 1.0);
        item = new ItemInSale(new Item(itemDTO));
    }
	 @AfterEach
    public void tearDown() {
        itemDTO = null;
        item = null;
    }

    @Test
    void testItemInSaleIncreaseCount() {
        assertNotNull(item);
        item.increaseCount();
        assertEquals(2, item.getCount());
    }

}
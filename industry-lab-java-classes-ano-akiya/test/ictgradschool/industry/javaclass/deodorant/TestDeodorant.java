package ictgradschool.industry.javaclass.deodorant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDeodorant {
    private Deodorant deo1, deo2;

    @BeforeEach
    void setUp() {
        deo1 = new Deodorant("Gentle", "Baby Powder", true, 4.99);
        deo2 = new Deodorant("Spring", "Blossom", false, 3.99);
    }

    @Test
    public void testPrice() {

        assertEquals(4.99, deo1.getPrice(), 1e-10);
        assertEquals(3.99, deo2.getPrice(), 1e-10);

        deo1.setPrice(2.56);
        assertEquals(2.56, deo1.getPrice(), 1e-10);

    }

    @Test
    public void testBrand() {

        assertEquals("Gentle", deo1.getBrand());
        assertEquals("Spring", deo2.getBrand());

        deo2.setBrand("Lynx");
        assertEquals("Lynx", deo2.getBrand());

    }

    @Test
    public void testRollOn() {
        assertEquals(true, deo1.isRollOn());
        assertEquals(false, deo2.isRollOn());
    }

    @Test
    public void testFragrance() {

        assertEquals("Baby Powder", deo1.getFragrance());
        assertEquals("Blossom", deo2.getFragrance());

        deo1.setFragrance("Garbage");
        assertEquals("Garbage", deo1.getFragrance());
    }

    @Test
    public void testMoreExpensiveThan() {

        assertEquals(true, deo1.isMoreExpensiveThan(deo2));
        assertEquals(false, deo2.isMoreExpensiveThan(deo1));

        deo1.setPrice(3);

        assertEquals(false, deo1.isMoreExpensiveThan(deo2));
        assertEquals(true, deo2.isMoreExpensiveThan(deo1));

        deo2.setPrice(3);

        assertEquals(false, deo1.isMoreExpensiveThan(deo2));
        assertEquals(false, deo2.isMoreExpensiveThan(deo1));

    }
}
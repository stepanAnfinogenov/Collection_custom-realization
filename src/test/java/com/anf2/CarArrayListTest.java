package com.anf2;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarArrayListTest {
    private CarList carArrayList;

    @BeforeEach
    void setUp() {
        carArrayList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carArrayList.add(new Car ("Brand" + i, i));
        }
    }

    @Test
    void get_whenAskExisingCar_returnRightCar() {
        Car car = carArrayList.get(0);
        Assert.assertEquals("Brand0", car.getBrand());
        Assert.assertEquals(0, car.getNumber());
    }

    @Test
    void add_whenAdded100Elements_sizeMustBe100() {
        Assert.assertEquals(100, carArrayList.size());
    }

    @Test
    void addByIndex_whenAddElementWithIndex11_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carArrayList.add(car, 11);
        Assert.assertEquals(101, carArrayList.size());
        Assert.assertEquals(car, carArrayList.get(11));
    }

    @Test
    void addByIndex_whenAddElementWithIntoFirstPosition_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carArrayList.add(car, 0);
        Assert.assertEquals(101, carArrayList.size());
        Assert.assertEquals(car, carArrayList.get(0));
    }

    @Test
    void addByIndex_whenAddElementWithIntoLastPosition_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carArrayList.add(car, carArrayList.size());
        Assert.assertEquals(101, carArrayList.size());
        Assert.assertEquals(car, carArrayList.get(100));
    }

    @Test
    void remove_whenElementRemoved_sizeMustBeDecreased() {
        Car car = new Car("Toyota", 5);
        carArrayList.add(car);
        Assert.assertEquals(101, carArrayList.size());
        Assert.assertTrue(carArrayList.remove(car));
        Assert.assertEquals(100, carArrayList.size());
    }

    @Test
    void remove_whenAttemptRemoveNonExistingElement_returnFalse() {
        Car car = new Car("Toyota", 5);
        Assert.assertFalse(carArrayList.remove(car));
        Assert.assertEquals(100, carArrayList.size());
    }

    @Test
    void removeAt_whenElementRemovedByIndex_sizeMustBeDecreased() {
        Car car6 = carArrayList.get(6);
        Car car7 = carArrayList.get(7);

        Assert.assertTrue(carArrayList.removeAt(6));
        Assert.assertEquals(99, carArrayList.size());
        Assert.assertFalse(car6.equals(carArrayList.get(6)));
        Assert.assertTrue(car7.equals(carArrayList.get(6)));
    }

    @Test
    void size() {
        Assert.assertEquals(100, carArrayList.size());
    }

    @Test
    void clear_whenListCleared_sizeMustBe0() {
        carArrayList.clear();
        Assert.assertEquals(0, carArrayList.size());
    }

    @Test
    void get_whenIndexOutOfBounds_throwIOBE() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            carArrayList.get(100);
        });
    }
}
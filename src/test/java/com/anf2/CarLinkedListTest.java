package com.anf2;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarLinkedListTest {
    private CarList carLinkedList;

    @BeforeEach
    void setUp() {
        carLinkedList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carLinkedList.add(new Car ("Brand" + i, i));
        }
    }

    @Test
    void get_whenAskExisingCar_returnRightCar() {
        Car car = carLinkedList.get(0);
        Assert.assertEquals("Brand0", car.getBrand());
        Assert.assertEquals(0, car.getNumber());
    }

    @Test
    void add_whenAdded100Elements_sizeMustBe100() {
        Assert.assertEquals(100, carLinkedList.size());
    }

    @Test
    void addByIndex_whenAddElementWithIndex11_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carLinkedList.add(car, 11);
        Assert.assertEquals(101, carLinkedList.size());
        Assert.assertEquals(car, carLinkedList.get(11));
    }

    @Test
    void addByIndex_whenAddElementWithIntoFirstPosition_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carLinkedList.add(car, 0);
        Assert.assertEquals(101, carLinkedList.size());
        Assert.assertEquals(car, carLinkedList.get(0));
    }

    @Test
    void addByIndex_whenAddElementWithIntoLastPosition_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carLinkedList.add(car, carLinkedList.size());
        Assert.assertEquals(101, carLinkedList.size());
        Assert.assertEquals(car, carLinkedList.get(100));
    }

    @Test
    void remove_whenElementRemoved_sizeMustBeDecreased() {
        Car car = new Car("Toyota", 5);
        carLinkedList.add(car);
        Assert.assertEquals(101, carLinkedList.size());
        Assert.assertTrue(carLinkedList.remove(car));
        Assert.assertEquals(100, carLinkedList.size());
    }

    @Test
    void remove_whenAttemptRemoveNonExistingElement_returnFalse() {
        Car car = new Car("Toyota", 5);
        Assert.assertFalse(carLinkedList.remove(car));
        Assert.assertEquals(100, carLinkedList.size());
    }

    @Test
    void removeAt_whenElementRemovedByIndex_sizeMustBeDecreased() {
        Car car6 = carLinkedList.get(6);
        Car car7 = carLinkedList.get(7);

        Assert.assertTrue(carLinkedList.removeAt(6));
        Assert.assertEquals(99, carLinkedList.size());
        Assert.assertFalse(car6.equals(carLinkedList.get(6)));
        Assert.assertTrue(car7.equals(carLinkedList.get(6)));
    }

    @Test
    void size() {
        Assert.assertEquals(100, carLinkedList.size());
    }

    @Test
    void clear_whenListCleared_sizeMustBe0() {
        carLinkedList.clear();
        Assert.assertEquals(0, carLinkedList.size());
    }

    @Test
    void get_whenIndexOutOfBounds_throwIOBE() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            carLinkedList.get(100);
        });
    }
}
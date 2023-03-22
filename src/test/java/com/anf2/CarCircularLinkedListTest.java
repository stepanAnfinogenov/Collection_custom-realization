package com.anf2;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarCircularLinkedListTest {
    private CarList carCircularLinkedList;

    @BeforeEach
    void setUp() {
        carCircularLinkedList = new CarCircularLinkedList();
        for (int i = 0; i < 100; i++) {
            carCircularLinkedList.add(new Car ("Brand" + i, i));
        }
    }

    @Test
    void get_whenAskExisingCar_returnRightCar() {
        Car car = carCircularLinkedList.get(0);
        Assert.assertEquals("Brand0", car.getBrand());
        Assert.assertEquals(0, car.getNumber());
    }

    @Test
    void add_whenAdded100Elements_sizeMustBe100() {
        Assert.assertEquals(100, carCircularLinkedList.size());
    }

    @Test
    void addByIndex_whenAddElementWithIndex11_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carCircularLinkedList.add(car, 60);
        Assert.assertEquals(101, carCircularLinkedList.size());
        Assert.assertEquals(car, carCircularLinkedList.get(60));
    }

    @Test
    void addByIndex_whenAddElementWithIntoFirstPosition_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carCircularLinkedList.add(car, 0);
        Assert.assertEquals(101, carCircularLinkedList.size());
        Assert.assertEquals(car, carCircularLinkedList.get(0));
    }

    @Test
    void addByIndex_whenAddElementWithIntoLastPosition_elementAddedSuccessfully() {
        Car car = new Car("Toyota", 5);
        carCircularLinkedList.add(car, carCircularLinkedList.size()-1);
        Assert.assertEquals(101, carCircularLinkedList.size());
        Assert.assertEquals(car, carCircularLinkedList.get(99));
    }

    @Test
    void remove_whenElementRemoved_sizeMustBeDecreased() {
        Car car = new Car("Toyota", 5);
        carCircularLinkedList.add(car);
        Assert.assertEquals(101, carCircularLinkedList.size());
        Assert.assertTrue(carCircularLinkedList.remove(car));
        Assert.assertEquals(100, carCircularLinkedList.size());
    }

    @Test
    void remove_whenAttemptRemoveNonExistingElement_returnFalse() {
        Car car = new Car("Toyota", 5);
        Assert.assertFalse(carCircularLinkedList.remove(car));
        Assert.assertEquals(100, carCircularLinkedList.size());
    }

    @Test
    void removeAt_whenElementRemovedByIndex_sizeMustBeDecreased() {
        Car car6 = carCircularLinkedList.get(6);
        Car car7 = carCircularLinkedList.get(7);

        Assert.assertTrue(carCircularLinkedList.removeAt(6));
        Assert.assertEquals(99, carCircularLinkedList.size());
        Car car62 = carCircularLinkedList.get(6);
        Car car72 = carCircularLinkedList.get(7);
        Assert.assertFalse(car6.equals(carCircularLinkedList.get(6)));
        Assert.assertTrue(car7.equals(carCircularLinkedList.get(6)));
    }

    @Test
    void size() {
        Assert.assertEquals(100, carCircularLinkedList.size());
    }

    @Test
    void clear_whenListCleared_sizeMustBe0() {
        carCircularLinkedList.clear();
        Assert.assertEquals(0, carCircularLinkedList.size());
    }

    @Test
    void get_whenIndexOutOfBounds_throwIOBE() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            carCircularLinkedList.get(100);
        });
    }

}
package com.anf2;

import java.util.Arrays;

public class CarArrayList implements CarList {
    private int size = 0;
    private Car[] array = new Car[10];

    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void add(Car car) {
        if (size >= array.length) {
            increaseArray();
        }
        array[size] = car;
        size++;
    }

    public boolean remove(Car car) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(car)){
                return removeAt(i);
            }
        }
        return false;
    }

    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size-1; i++) {
            array[i] = array[index+1];
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        array = new Car[10];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
//        Car[] newArr = new Car[array.length *2];
//        int i = 0;
//        for (Car car : array) {
//            newArr[i++] = car;
//        }
//
//        array = newArr;
        array = Arrays.copyOf(array, array.length*2);
    }
}

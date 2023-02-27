package com.anf2;

public class CarLinkedList implements CarList {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        if (index == size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            Node node = new Node(null, car, null);
            first = node;
            last = node;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        checkIndex(index);

        if (index == size) {
            add(car);
            return;
        }

        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);

        nodeNext.previous = newNode;

        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }

        size++;
    }

    @Override
    public boolean remove(Car car) {
        Node nodeRemove = first;
        for (int i = 0; i < size; i++) {
            if(nodeRemove.value.equals(car)){
                return removeAt(i);
            }
            nodeRemove = nodeRemove.next;
        }

        return false;
    }

    @Override
    public boolean removeAt(int index) {
        if (index < 0 || index > size ) {
            return false;
        }
        Node nodeRemove = getNode(index);
        Node nodeNext = nodeRemove.next;
        Node nodePrevious = nodeRemove.previous;

        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }

        if (nodePrevious!=null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node {

        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}

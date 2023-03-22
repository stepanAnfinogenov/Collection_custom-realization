package com.anf2;

import java.util.NoSuchElementException;

/**
 * @author Stepan Anfi
 * 3/22/2023
 */

public class CarCircularLinkedList implements CarList {
    private int size = 0;
    private Node firstNode = null;
    private Node lastNode = null;

    @Override
    public Car get(int index) {
        checkCorrectIndex(index);
        if (index == 0) {
            return getFirstNode().value;
        } else if (index == size - 1) {
            return getLastNode().value;
        } else {
            Node current = firstNode;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextNode();
            }
            return current.value;
        }
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            firstNode = new Node(car, firstNode);
            size++;
        } else if (size == 1) {
            lastNode = new Node(car, firstNode);
            firstNode.setNextNode(lastNode);
            size++;
        } else {
            Node previous = lastNode;
            lastNode = new Node(car, firstNode);
            previous.setNextNode(lastNode);
            size++;
        }
    }

    @Override
    public void add(Car car, int index) {
        checkCorrectIndex(index);
        if (size == 0) {
            firstNode = new Node(car, firstNode);
            size++;
        } else if (size == 1) {
            lastNode = new Node(car, firstNode);
            firstNode.setNextNode(lastNode);
            size++;
        }  else if (index == 0 || index == size) {
            Node next = firstNode;
            firstNode = new Node(car, next);
            lastNode.setNextNode(firstNode);
            size++;
        } else {
            Node current = firstNode;
            for (int i = 0; i < index-2; i++) {
                current = current.getNextNode();
            }
            Node node = new Node(car, current.nextNode);
            current.setNextNode(node);
            size++;
        }

    }

    @Override
    public boolean remove(Car car) {
        Node previous = null;
        Node current = firstNode;
        for (int i = 0; i < size; i++) {
            if (!current.value.equals(car)){
                previous = current;
                current = current.nextNode;
            } else {
                previous.setNextNode(current.nextNode);
                size--;

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        if (index < 0 || index > size ) {
            return false;
        }

        if (index == 0) {
            lastNode.setNextNode(firstNode.getNextNode());
            size--;
            return true;
        } else {
            Node current = firstNode;
            Node previous = null;
            for (int i = 1; i < index; i++) {
                current = current.getNextNode();
                if (i == index-2) {
                    previous = current;
                }
            }
            // current 1,2
            Node next = current.getNextNode();
            previous.nextNode = next;
            size--;
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
    }

    private void checkCorrectIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index mustn't be < 0 or > size of list");
        }
    }

    class Node {
        private Car value;
        private Node nextNode;

        public Node(Car value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public Car getValue() {
            return value;
        }

        public void setValue(Car value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    public int getSize() {
        return size;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }
}

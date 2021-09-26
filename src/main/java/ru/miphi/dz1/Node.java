package ru.miphi.dz1;


class Node {
    private Node next = null;
    private Object instance = null;
    private Node prev = null;


    Node(Object a) {
        this.instance = a;

    }


    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

}


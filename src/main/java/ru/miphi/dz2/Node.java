package ru.miphi.dz2;


class Node {
    private Node next = null;
    private Integer instance = null;
    private Node prev = null;


    Node(Integer a) {
        this.instance = a;

    }


    public Integer getInstance() {
        return instance;
    }

    public void setInstance(Integer instance) {
        this.instance = instance;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

}


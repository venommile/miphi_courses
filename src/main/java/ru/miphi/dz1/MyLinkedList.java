package ru.miphi.dz1;


import java.util.Objects;

public class MyLinkedList {
    private Node head = null;
    private int length = 0;
    private Comparator comparator = new Comparator();


    public MyLinkedList() {

    }

    public Node getHead() {
        return this.head;
    }

    public void add(Object a) {

        if (this.length == 0) {
            head = new Node(a);

        } else {
            int i = 0;
            Node element = this.head;
            while (i < length - 1) {
                element = element.getNext();
                i++;
            }
            element.setNext(new Node(a));
            element.getNext().setPrev(element);

        }
        this.length++;


    }//works

    public void add(Object a, int index) {
        if (index >= this.length) {
            add(a);

        } else if (index == 0) {
            Node element = new Node(a);
            element.setNext(this.head);

            this.head = element;
            if (length != 0) {
                element.getNext().setPrev(element);
            }
            this.length++;

        } else if (this.length == 0) {
            head = new Node(a);
            this.length++;

        } else if (index > 0) {
            Node element = searchElement(index);
            Node tail = element.getNext();
            element.setNext(new Node(a));
            if (tail != null) {
                element.getNext().setNext(tail);
                element.getNext().setPrev(element);
                tail.setPrev(element.getNext());
            } else {//tail is null not Node
                element.getNext().setPrev(element.getNext());
            }
            this.length++;


        }
    } //если index>size()-1->добавляем в конец,если index<0 ничего не делаем

    public Object remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        } else if (index == 0) {
            Node element = this.head;
            this.head = this.head.getNext();
            this.length--;
            return element.getInstance();

        } else {
            Node element = searchElement(index);
            Node tail = element.getNext().getNext();
            Node ans = element.getNext();
            if (tail != null) {
                element.setNext(tail);
                element.getNext().setPrev(element);
            }

            this.length--;
            return ans.getInstance();
        }

    } // works

    public Object get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        } else {
            return searchElement(index + 1).getInstance();
        }
    } // works

    private Node searchElement(int index) { //возвращает родителя искомого элемента
        int i = 0;
        Node element = this.head;
        while (i < index - 1) {
            element = element.getNext();
            i++;
        }

        return element;
    }

    public Object set(Object a, int index) {
        if (index < 0 || index >= this.length) {
            return null;

        } else if (index == 0) {
            Node element = new Node(a);
            Node ans = this.head;
            element.setNext(head.getNext());
            this.head = element;
            return ans;

        } else {
            Node element = searchElement(index);
            Node ending = element.getNext().getNext();

            Node ans = element.getNext();
            element.setNext(new Node(a));

            element.getNext().setPrev(element);


            if (ending != null) {
                element.getNext().setNext(ending);
            }

            return ans.getInstance();
        }
    }


    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }//works

    public boolean contains(Object a) {
        return indexOf(a) != -1;
    } // works

    public int indexOf(Object a) {
        Node element = this.head;//при нескольких одинаковых вернуть первый добавленный?
        int i = 0;

        while (i <= this.length - 1) {

            if (comparator.equals(a, element.getInstance())) { // check equals
                return i;
            }
            i++;
            element = element.getNext();
        }
        return -1;

    }

//    public void showAll() {
//        Node element = this.head;
//        int i = 0;
//        System.out.print("[");
//        while (i < this.length) {
//
//            System.out.print(element.getInstance() + ", ");
//            element = element.getNext();
//            i++;
//
//        }
//        System.out.print("]\n");

    //}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList list = (MyLinkedList) o;

        if (length == list.length) {
            for (int i = 0; i < length; i++) {
                if (!list.get(i).equals(this.get(i))) {
                    return false;
                }
            }

        } else {
            return false;
        }
        return true;
    }
}

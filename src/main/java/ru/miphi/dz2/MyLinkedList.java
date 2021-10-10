package ru.miphi.dz2;


import ru.miphi.dz1.Comparator;

public class MyLinkedList {
    private Node head = null;
    private int length = 0;
    private final Comparator comparator = new Comparator();


    public MyLinkedList() {

    }

    public Node getHead() {
        return this.head;
    }

    public void add(Integer a) {

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

    public void add(Integer a, int index) {
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

    public Integer remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        } else if (index == 0) {
            Node element = this.head;
            this.head = this.head.getNext();
            this.length--;
            return (Integer) element.getInstance();

        } else {
            Node element = searchElement(index);
            Node tail = element.getNext().getNext();
            Node ans = element.getNext();
            if (tail != null) {
                element.setNext(tail);
                element.getNext().setPrev(element);
            }

            this.length--;
            return (Integer) ans.getInstance();
        }

    } // works

    public Integer get(int index) {
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

    public Integer set(Integer a, int index) {
        if (index < 0 || index >= this.length) {
            return null;

        } else if (index == 0) {
            Node element = new Node(a);
            Node ans = this.head;
            element.setNext(head.getNext());
            this.head = element;
            return (Integer) ans.getInstance();

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

    public boolean contains(Integer a) {
        return indexOf(a) != -1;
    } // works

    public int indexOf(Integer a) {
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

    public void showAll() {
        Node element = this.head;
        int i = 0;
        System.out.print("[");
        while (i < this.length) {

            System.out.print(element.getInstance() + ", ");
            element = element.getNext();
            i++;

        }
        System.out.print("]\n");

    }

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

    public static Node merge(Node head1, Node head2) {
        MyLinkedList ans = new MyLinkedList();
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                ans.add(head2.getInstance());
                head2 = head2.getNext();
            } else if (head2 == null) {
                ans.add(head1.getInstance());
                head1 = head1.getNext();
            } else if (head1.getInstance() >= head2.getInstance()) {
                ans.add(head2.getInstance());
                head2 = head2.getNext();
            } else if (head2.getInstance() > head1.getInstance()) {
                ans.add(head1.getInstance());
                head1 = head1.getNext();

            }
            int i = 0;
        }

        return ans.getHead();
    }

    public static MyLinkedList merge(MyLinkedList list1, MyLinkedList list2) {
        MyLinkedList ans = new MyLinkedList();
        int k1 = 0, k2 = 0;
        while (k1 < list1.size() || k2 < list2.size()) {
            if (k1 >= list1.size()) {
                ans.add(list2.get(k2));
                k2++;
            }
            else if (k2 >= list2.size()) {
                ans.add(list1.get(k1));
                k1++;
            }
            else if (list1.get(k1) <= list2.get(k2)) {
                ans.add(list1.get(k1));
                k1++;
            } else {
                ans.add(list2.get(k2));
                k2++;

            }


        }
        return ans;

    }

    public void print() {
        Node head = this.head;
        System.out.print('[');
        while (head.getNext() != null) {
            System.out.print(head.getInstance() + ", ");
            head = head.getNext();
        }
        System.out.print(head.getInstance()+"]"+"\n");
    }

}
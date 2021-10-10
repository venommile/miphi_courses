package ru.miphi.dz2;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        list1.add(-100);
        list1.add(-10);
        list1.add(1);
        list1.add(2);
        list1.add(100);
        list1.add(100);
        MyLinkedList list2 = new MyLinkedList();
        list2.add(-1000);
        list2.add(-100);
        list2.add(-50);
        list2.add(10);
        list2.add(11);
        list2.add(100);
        MyLinkedList list3 = MyLinkedList.merge(list1, list2);
        list3.print();
        Node list4 = MyLinkedList.merge(list1.getHead(), list2.getHead());
        System.out.print('[');
        Node head = list4;
        while (head.getNext() != null) {
            System.out.print(head.getInstance() + ", ");
            head = head.getNext();
        }
        System.out.print(head.getInstance()+"]"+"\n");
    }


}

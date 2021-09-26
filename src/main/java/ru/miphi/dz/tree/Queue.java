package ru.miphi.dz.tree;

import ru.miphi.dz1.MyLinkedList;

class Queue extends MyLinkedList {
    public Object pop() {
        return this.remove(0);
    }
}

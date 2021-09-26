package ru.miphi.dz.tree;

import ru.miphi.dz1.Comparator;
import ru.miphi.dz1.MyLinkedList;

class Node {

    private Object instance;
    private Node parent = null;
    private MyLinkedList children = new MyLinkedList();
    private Comparator comparator = new Comparator();

    Node(Object obj) {
        this.instance = obj;
    }

    public MyLinkedList getChildren() {
        return this.children;
    }

    public void addChild(Node value) {
        value.setParent(this);
        this.children.add(value);
    }

    public boolean removeChild(Node value) {
        return removeChild(children.indexOf(value));
    }

    public boolean removeChild(int index) {
        if (index >= 0 && index < children.size()) {
            children.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node obj) {
        this.parent = obj;
    }

    public Tree subtree() {
        return new Tree(this);
    }

    public int size() {
        return children.size();
    }

    public MyLinkedList path() {//путь до корня.Вместе с самим объктом.Импользуется в поиске общего родителя
        MyLinkedList path = new MyLinkedList();
        path.add(this);
        Node parent = this.parent;
        while (parent != null) {
            path.add(parent);
            parent = parent.parent;
        }
        return path;
    }

    public Node findParent(Node another) {
        MyLinkedList parents1 = this.path();
        MyLinkedList parents2 = another.path();
        for (int i = 0; i < parents1.size(); i++) {
            for (int j = 0; j < parents2.size(); j++) {
                if (comparator.equals((parents1.get(i)), parents2.get(j))) {
                    return (Node) parents1.get(i);
                }
            }
        }
        return null; //например. если такого узла нет в дереве
    }

    public Object getInstance() {
        return this.instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node object = (Node) o;
        return this.instance.equals(object.instance) && this.getChildren().equals(object.getChildren());


    }
}

package ru.miphi.dz.tree;

import ru.miphi.dz1.Comparator;
import ru.miphi.dz1.MyLinkedList;

import java.util.Objects;

public class Tree {
    private Node root = null;
    private Comparator comparator = new Comparator();




    public void setRoot(Node value){
        this.root = value;

    }
    public Node getRoot(){
        return this.root;
    }
    public Tree(){

    }
    public Tree(Node root) {
        this.root = root;
    }

    public int size() {
        return toList().size();
    }

    public boolean isEmpty() {
        return this.root==null;
    }



    public MyLinkedList toList() {//возвращаю список объектов,а не список Node'ов
        Queue neighbours = new Queue();
        neighbours.add(root);
        MyLinkedList visited = new MyLinkedList();

        while (neighbours.size() != 0) {
            MyLinkedList children = ((Node) neighbours.get(0)).getChildren();

            for (int i = 0; i < children.size(); i++) {
                Node child  = (Node) children.get(i);
                if (!visited.contains(child.getInstance())) {
                    neighbours.add(child);
                }

            }
            visited.add(((Node) neighbours.pop()).getInstance());

        }
        return visited;
    }

    public Node find(Object value) {
        Queue neighbours = new Queue();
        neighbours.add(root);
        MyLinkedList visited = new MyLinkedList();

        while (neighbours.size() != 0) {
            MyLinkedList children = ((Node) neighbours.get(0)).getChildren();

            for (int i = 0; i < children.size() - 1; i++) {
                Node child  = (Node) children.get(i);
                if (comparator.equals(child.getInstance(),value)){
                    return child;
                }
                if (!visited.contains(child.getInstance())) {
                    neighbours.add(child);
                }

            }
            visited.add(((Node) neighbours.pop()).getInstance());

        }
        return null;
    }

}



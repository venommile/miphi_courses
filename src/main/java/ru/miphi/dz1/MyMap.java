package ru.miphi.dz1;

import java.util.Objects;


public class MyMap {
    private MyLinkedList map = new MyLinkedList();
    final private Comparator comparator = new Comparator();


    public void put(Object key, Object value) {

        MyPair pair = new MyPair(key, value);
        if (this.size() == 0) {
            this.map.add(pair);
        } else {
            MyPair checkInMap = searchPair(key);

            if ((int) (checkInMap.getValue()) == -1) {
                this.map.add(pair);
            } else {
                this.update((int) checkInMap.getValue(), key, value);
            }
        }
    }

    private void update(int index, Object key, Object value) {
        this.map.set(new MyPair(key, value), index);
    }

    public Object get(Object key) {
        return this.get(key, null);

    }

    private MyPair searchPair(Object key) { // [searchedPair,index] работает для всех кроме size()==0
        Node element = this.map.getHead();
        int i = 0;
        if (this.size() == 0) {
            return null;
        }
        while (i < this.size() - 1 && !comparator.equals(((MyPair) element.getInstance()).getKey(), key)) {
            element = element.getNext();
            i++;
        }
        if (comparator.equals(((MyPair) element.getInstance()).getKey(), key)) {
            return new MyPair(element.getInstance(), i);
        }
        return new MyPair(element.getInstance(), -1);//element,-1
    }

    public Object get(Object key, Object bydefault) {
        MyPair checkInMap = searchPair(key);
        MyPair searchedPair = (MyPair) checkInMap.getKey();
        if ((int) (checkInMap.getValue()) != -1 &&
                searchedPair.getValue() != null) {
            return searchedPair.getValue();
        } else if ((int) checkInMap.getValue() != -1 &&
                searchedPair.getValue() == null) {

            searchedPair.setValue(bydefault);
            return bydefault;
        } else {
            this.map.add(new MyPair(key, bydefault));
            return bydefault;

        }

    }

    public Object remove(Object key) {
        if (this.size() == 0) {
            return null;
        }
        MyPair ans = searchPair(key);
        int index = (int) ans.getValue();
        if (index != -1) {
            return ((MyPair) this.map.remove(index)).getValue();

        } else {
            return null;
        }
    }

    public boolean keyContains(Object key) {
        MyPair searchedPair = (MyPair) searchPair(key).getKey();
        return comparator.equals(searchedPair.getKey(), key);
    }

    public MyLinkedList getValues() {
        MyLinkedList values = new MyLinkedList();
        Node element = this.map.getHead();
        int i = 0;
        while (i < map.size()) {
            values.add(((MyPair) element.getInstance()).getValue());
            element = element.getNext();


            i++;
        }
        return values;
    }

    public MyLinkedList getKeys() {
        MyLinkedList keys = new MyLinkedList();
        Node element;
        element = this.map.getHead();
        int i = 0;
        while (i < map.size()) {
            keys.add(((MyPair) element.getInstance()).getKey());
            element = element.getNext();


            i++;
        }
        return keys;
    }

    public MyLinkedList getEntries() {
        return this.map;

    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

//    public void showAll() {
//        this.map.showAll();
//        System.out.println(this.map.size());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyMap myMap = (MyMap) o;
        return map.equals(myMap.map);
    }

}

class MyPair extends MyLinkedList {
    private MyLinkedList pair = null;

    public MyPair(Object key, Object value) {
        this.pair = new MyLinkedList();
        this.pair.add(key);
        this.pair.add(value);
    }


    Object getKey() {
        return this.pair.get(0);
    }

    Object getValue() {
        return this.pair.get(1);
    }

    void setValue(Object object) {
        this.pair.set(object, 1);
    }


}
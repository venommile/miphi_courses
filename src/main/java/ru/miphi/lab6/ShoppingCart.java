package ru.miphi.lab6;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter

public class ShoppingCart implements Serializable {
    private static final long SerialVersionUID = 42L;
    private int cartID;
    private ArrayList<Item> items;
    private int itemCount;
    private transient double cartTotal;
    private LocalDateTime SerializationTime;

    @Builder
    public ShoppingCart(int cartID, ArrayList<Item> items, int itemCount) {
        this.cartID = cartID;
        this.items = items;
        this.itemCount = itemCount;
        this.cartTotal = items.stream().mapToDouble(Item::getCost).sum();

    }


    private void writeObject(ObjectOutputStream oos) throws IOException {
        this.SerializationTime = LocalDateTime.now();
        oos.defaultWriteObject();
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        setCartTotal();
        System.out.println(getSerializationTime());
    }

    public void setCartTotal() {
        this.cartTotal = items.stream().mapToDouble(Item::getCost).sum();
    }

    @Override
    public String toString() {
        return "cartID: " + this.cartID + "\n" +
                "itemCount: " + this.itemCount + "\n" +
                "cartTotal: " + this.cartTotal;
    }
}

package ru.miphi.lab6;

import java.io.*;
import java.util.ArrayList;

public class SerializeCart {
    public static void main(String[] args) {

        String serializeFile = args[0];
        ArrayList<Item> itemsList = new ArrayList<>();
        itemsList.add(Item.builder().description("keyboard").id(1).cost(1000.0).build());
        itemsList.add(Item.builder().description("monitor").id(2).cost(2500).build());
        itemsList.add(Item.builder().description("graphicscard").id(3).cost(5000.0).build());

        ShoppingCart myCart = ShoppingCart.builder().cartID(1).items(itemsList).itemCount(3).build();

        try (FileOutputStream fos = new FileOutputStream(serializeFile);
             ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            System.out.println("Cart total:" + myCart.getCartTotal());
            out.writeObject(myCart);
            System.out.println("Serialization make successfully!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileInputStream fis = new FileInputStream(serializeFile);
             ObjectInputStream in = new ObjectInputStream(fis);
        ) {
            ShoppingCart newCart = (ShoppingCart) in.readObject();
            System.out.println("De-serialization make successfully!");
            System.out.println(newCart);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

package com.example.demo.menu;

public interface Menu {
    void show();
    void exit();

    default void showItems(String[] items){
        for (String item : items) {
            System.out.println(item);

        }

    }

}

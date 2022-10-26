package com.company;

public class Main {

    public static void main(String[] args){

        Navigator navigator = new Navigator(10);
        new Thread(navigator).start();
    }
}

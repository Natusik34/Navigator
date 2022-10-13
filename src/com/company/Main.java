package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Navigator navigator = new Navigator(500);

        new Thread(navigator).start();
       // while(navigator.getDistance() > 0)
        //    System.out.println(navigator.getDistance());
       // Thread.sleep(1000);

    }
}

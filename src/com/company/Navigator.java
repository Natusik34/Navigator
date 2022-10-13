package com.company;

import java.util.Random;
import java.util.Scanner;

public class Navigator implements Runnable{
    int speed; //скорость
    int averageSpeed; //средняя скор
    int time; // время
    int minSpeed = 10; //мин скорость
    int maxSpeed = 100; //макс скорость
    //Random random = new Random();
    private int distance;
    int distanceTraveled = 0; //пройденая дистанции
    int ostDist; //оставшаяся дистанция
    int timeDist; //время пути


    //int speed = new Random().nextInt(maxSpeed - minSpeed) + maxSpeed;
    // Scanner scanner = new Scanner(System.in);
    //  System.out.println("Введите расстояние");
    //  int distance = scanner.nextInt();


    public Navigator(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return distance;
    }
    
    @Override
    public void run() {
        while (distance > 0){

            speed = new Random().nextInt(maxSpeed - minSpeed) + minSpeed; // задается рандомная скорость
            timeDist = distance/speed; //время пути
            averageSpeed = distance/ timeDist; //средняя скорость
            distanceTraveled = distanceTraveled + averageSpeed;// пройденная дистанция
            ostDist = distance - distanceTraveled;//оставшаяся дистанция
            time = ostDist/averageSpeed;//оставшееся время
            distance = distance - distanceTraveled;
            if(time < 0) return; //чтобы оставшееся время не уходило в минус
            if(ostDist < 0) return; //чтобы оставшееся расстояние не уходило в минус

            System.out.println("Средняя скорость " + averageSpeed + " м/с" ); //типо норм
            System.out.println("Оставшееся время " + time + " мин"); //параша
            System.out.println("Оставшееся расстояние " + ostDist + " м/с" ); //параша
            System.out.println(" ");
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

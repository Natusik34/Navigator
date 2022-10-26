package com.company;

public class Navigator implements Runnable{
    private double distance;
    double minSpeed = 100; //мин скорость
    double maxSpeed = 200; //макс скорость
    double speed; //скорость
    double averageSpeed = minSpeed; //средняя скорость
    double time;//время

    public Navigator(double distance){
        this.distance = distance;//расстояние в км
    }

    public double getDistance(){
        return distance;
    }

    @Override
    public void run() {
        while(distance>0){
            speed = Math.random()*((maxSpeed-minSpeed)+1)+minSpeed; //скорость рандом
            //averageSpeed = minSpeed;//присваиваем ср скорости мин скорость
            averageSpeed = (averageSpeed + speed)/2;//считаем ср скорость
            distance = distance - (speed/3600); // оставшаяся дистанция
            time = distance/(averageSpeed/60);//оставшееся время(переводим секунды в минуты)

            System.out.println("Average speed " + String.format("%.3f", averageSpeed) + " km/h" ); //вывод средней скорости
            System.out.println("Remaining time " + String.format("%.2f", time) + " min"); //вывод сколько минут осталось
            System.out.println("Remaining distance " + String.format("%.3f", distance) + " km/h" ); //вывод оставшейся дистанции
            System.out.println(" ");

            if(distance < 0){
                System.out.println("You arrived!");
            }else if (time < 0){
                System.out.println("You arrived!");
            }

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
package com.cbellmont;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        concurrencyWithThread();
        concurrencyWithRunnable();
        concurrencyWithRunnableDouble();
        concurrencyThreadWithCallback();
    }


    private static void concurrencyWithThread(){
        Thread t1 = new ThreadCustom();
        t1.start();
        Thread t2 = new ThreadCustom();
        t2.start();
    }


    private static void concurrencyWithRunnable(){
        Runnable runnable = () -> {
            for(int i=0; i<10; i++) {
                double sleepingTime = Math.random() * 1000;
                ProcessHandle processHandle = ProcessHandle.current();

                System.out.println("Soy la variable concurrencyWithRunnable con PID " + processHandle.pid() + ", pero mi id es " + Thread.currentThread().getId() + ". Estoy en la iteración " + i + " y dormiré " + sleepingTime + " segundos");
                try {
                    sleep((int) sleepingTime);
                } catch(Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
        runnable.run();
        runnable.run();
    }

    private static void concurrencyWithRunnableDouble(){
        Runnable runnable = () -> {
            for(int i=0; i<10; i++) {
                double sleepingTime = Math.random() * 1000;
                ProcessHandle processHandle = ProcessHandle.current();

                System.out.println("Soy la variable concurrencyWithRunnableDouble con PID " + processHandle.pid() + ", pero mi id es " + Thread.currentThread().getId() + ". Estoy en la iteración " + i + " y dormiré " + sleepingTime + " segundos");
                try {
                    sleep((int) sleepingTime);
                } catch(Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
        runnable.run();
        runnable.run();
    }


    interface Callback {
        void executeCallback(Double result);
    }

    private static void concurrencyThreadWithCallback() {
        Callback callback1 = result -> System.out.println("Ejecutándose el callback1, de ThreadCustomCallback t1 con resultado = " + result);
        Callback callback2 = result -> System.out.println("Ejecutándose el callback2, de ThreadCustomCallback t2 con resultado = " + result);

        Thread t1 = new ThreadCustomCallback(callback1);
        t1.start();
        Thread t2 = new ThreadCustomCallback(callback2);
        t2.start();
    }
}

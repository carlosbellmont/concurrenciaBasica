package com.cbellmont;

class ThreadCustom extends Thread {

    @Override
    public void run() {

        for(int i=0; i<10; i++) {
            double sleepingTime = Math.random()*1000;
            ProcessHandle processHandle = ProcessHandle.current();

            System.out.println("Soy la variable ThreadCustom con PID  " + processHandle.pid() + ", pero mi id es " + getId() + ". Estoy en la iteración " + i + " y dormiré " + sleepingTime + " segundos");
            try {
                sleep((int) sleepingTime);
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        }

    }

}
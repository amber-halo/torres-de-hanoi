package com.pruebas;

public class ThreadA {
	public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
 
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                
                System.out.println("threadA thread: " + Thread.currentThread());
                
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
        	
        	System.out.println("threadB thread: " + Thread.currentThread());
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();
        }
    }
}

package org.example.pojo;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        t.start();

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        for(Integer i: list){
            new Thread(()->printData(i)).start();
        }

        System.out.println("Main Method execution completed");
    }

    private synchronized static void printData(Integer i) {
        for(int j=0; j<3; j++){
            System.out.println(Thread.currentThread().getName()+" prints i: "+i+" j: "+j);
        }
    }
}

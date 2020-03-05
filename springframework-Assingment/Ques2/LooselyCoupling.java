package com.tothenew.bootcamp.springframework.Ques2;

import com.tothenew.bootcamp.springframework.worker;

//Ques 2:Write a program to demonstrate Loosely Coupled code.
class LazyWorker1 implements worker{
    @Override
    public void doWork() {
        System.out.println("LazyWorker is doing work");
    }
}

class ExcellantWorker implements worker{
    @Override
    public void doWork() {
        System.out.println("Excellant Worker is doing work");
    }
}

class PunctualWoker implements worker{
    @Override
    public void doWork() {
        System.out.println("Punctual Worker is doing work");
    }
}
public class LooselyCoupling {
    public static void main(String[] args) {

        worker wr = new LazyWorker1();
        wr.doWork();
        wr = new ExcellantWorker();
        wr.doWork();
        wr = new PunctualWoker();
        wr.doWork();
    }
}

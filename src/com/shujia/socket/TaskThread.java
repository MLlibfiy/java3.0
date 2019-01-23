package com.shujia.socket;

import java.io.Serializable;

public class TaskThread extends Thread implements Serializable{
    @Override
    public void run() {
        System.out.println("线程方法");
    }
}

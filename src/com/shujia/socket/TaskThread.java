package com.shujia.socket;

import java.io.Serializable;

public class TaskThread implements Runnable ,Serializable {
    @Override
    public void run() {
        System.out.println("线程方法");
    }
}

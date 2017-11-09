package com.vivekaditya.designpatterns.gof.creational;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonCaller {

	public static void main(String[] args) {
		boolean threadFlag = false;
		if(threadFlag){
			Singleton obj1 = Singleton.getInstance();
			Singleton obj2 = Singleton.getInstance();
			System.out.println(obj1);
			System.out.println(obj2);
		}else{
			ExecutorService executor = Executors.newFixedThreadPool(5);
			for (int i = 0; i < 10; i++) {
				Runnable worker = new WorkerThread();
				executor.execute(worker);
			}
			executor.shutdown();
			while (!executor.isTerminated()) {
			}
		}
	}
}

class WorkerThread implements Runnable {
	public WorkerThread() {
	}

	@Override
	public void run() {
		Singleton obj1 = Singleton.getInstance();
		System.out.println(obj1);
	}
}
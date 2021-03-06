package controller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lib.Results;
import model.ApacheLog;


public class Control {
	private int size = 100;
	private ApacheLog[] apacheLog = new ApacheLog[size];
	private int begin;
	private int end;
	private int qtd;
	private Lock lock = new ReentrantLock();
	private Condition full = lock.newCondition();
	private Condition empty = lock.newCondition();
	private Results results = new Results();
	
	public Control() {
		begin = end = 0;
		this.qtd = 0;
	}

	public void insertObject(ApacheLog ap) throws InterruptedException {
		lock.lock();
		while(qtd == 100)
			full.await();
		
		apacheLog[end] = ap;
		end = (end + 1) % size;
		qtd++;
		
		empty.signalAll();
		lock.unlock();
	}
	
	public ApacheLog getObject() throws InterruptedException {
		lock.lock();
		
		while(qtd == 0)
			empty.await();
		
		ApacheLog apacheTemp = apacheLog[begin];
		begin = (begin + 1) % size;
		qtd--;
		
		full.signalAll();
		lock.unlock();
		
		return apacheTemp;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}        
}

package lib;


public class LogPartQueue {
	private int size = 10;
	private String[] logPartQueue = new String[size];
	private int begin;
	private int end;
	private int qtd;
	
	
	
	public LogPartQueue() {
		begin = end = 0;
		this.qtd = 0;
	}
	
	public synchronized void AddLine(String line) throws InterruptedException {
		while(qtd == 10)
			wait();
		
		logPartQueue[end] = line;
		end = (end + 1) % size;
		qtd++;
		notifyAll();
	}
	
	public synchronized String getLine() throws InterruptedException {
		while(qtd == 0)
			wait();
		
		String line = logPartQueue[begin];
		begin = (begin + 1) % size;
		qtd--;
		
		notifyAll();
		
		return line;
	}

}

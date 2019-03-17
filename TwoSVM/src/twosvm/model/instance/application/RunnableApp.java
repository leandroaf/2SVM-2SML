package twosvm.model.instance.application;

public class RunnableApp implements Runnable {

	public Thread t;
	private String threadName;
	boolean suspended = false;

	RunnableApp(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 10; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(300);
				synchronized (this) {
					while (suspended) {
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	/**
	 * This method start application
	 */
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	/**
	 * This method puts a thread in suspended state and can be resumed using
	 * resume() method
	 */
	void suspend() {
		suspended = true;
	}

	/**
	 * This method resumes a thread which was suspended using suspend() method
	 */
	synchronized void resume() {
		suspended = false;
		notify();
	}

}

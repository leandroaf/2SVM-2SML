package twosvm.model.instance.application;

public class RunnableAppTest {
	   public static void main(String args[]) {

	      RunnableApp R1 = new RunnableApp( "Thread-1");
	      R1.start();

	      RunnableApp R2 = new RunnableApp( "Thread-2");
	      R2.start();

	      try {
	         Thread.sleep(1000);
	         R1.suspend();
	         System.out.println("Suspending First Thread");
	         Thread.sleep(1000);
	         R1.resume();
	         System.out.println("Resuming First Thread");
	         R2.suspend();
	         System.out.println("Suspending thread Two");
	         Thread.sleep(1000);
	         R2.resume();
	         System.out.println("Resuming thread Two");
	      } catch (InterruptedException e) {
	         System.out.println("Main thread Interrupted");
	      }
	      try {
	         System.out.println("Waiting for threads to finish.");
	         R1.t.join();
	         R2.t.join();
	      } catch (InterruptedException e) {
	         System.out.println("Main thread Interrupted");
	      }
	      System.out.println("Main thread exiting.");
	   }
	}

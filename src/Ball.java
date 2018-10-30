

public class Ball implements MyThrowable {

	
	public void myThrow() {
		System.out.print("Ball: ");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("o");
		}
		System.out.println();		
	}
	
}

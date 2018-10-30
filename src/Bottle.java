

public class Bottle implements MyThrowable{
	
	private boolean opened;
	private int amount;

	public Bottle() {
	}

	public Bottle(boolean opened, int amount) {
		this.opened = opened;
		this.amount = amount;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int drain() {
		if (opened == false) {
			System.err.println("Bottle is closed.");
			return 0;
		}
		if (amount == 0) {
			System.err.println("Bottle is empty.");
			return 0;
		}
		amount--;
		return 1;
	}

	@Override
	public void myThrow() {
		System.out.print("Bottle: ");
		for (int i = 0; i < 10; i++) {			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("0");
		}
		System.out.println();
	}

	
	
}

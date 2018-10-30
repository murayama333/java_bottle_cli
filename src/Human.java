

public class Human {
	private String name;

	public Human(String name) {
		this.name = name;
	}

	public void drink(Bottle bottle) {
		int water = bottle.drain();
		System.out.println(name + " drink : " + water);
	}
	
	public void throw2(MyThrowable throwable) {
		throwable.myThrow();
	}
}

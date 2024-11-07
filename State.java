abstract class BulbState {
	abstract void turnOn(Bulb bulb);
	abstract void turnOff(Bulb bulb);
}

class OnState extends BulbState {
	void turnOn(Bulb bulb) {
		System.out.println("The bulb is already ON.");
	}

	void turnOff(Bulb bulb) {
		System.out.println("Turning the bulb OFF.");
		bulb.setState(new OffState());
	}
}

class OffState extends BulbState {
	void turnOn(Bulb bulb) {
		System.out.println("Turning the bulb ON.");
		bulb.setState(new OnState());
	}

	void turnOff(Bulb bulb) {
		System.out.println("The bulb is already OFF.");
	}
}


class Bulb {
	private BulbState state;

	public Bulb() {
		this.state = new OffState();
	}

	public void setState(BulbState state) {
		this.state = state;
	}

	public void turnOn() {
		state.turnOn(this);
	}

	public void turnOff() {
		state.turnOff(this);
	}
}

public class Main {
	public static void main(String[] args) {
		Bulb bulb = new Bulb();

		bulb.turnOn();
		bulb.turnOff();
		bulb.turnOff();
		bulb.turnOn();   
		bulb.turnOn();   
		bulb.turnOff();  
	}
}

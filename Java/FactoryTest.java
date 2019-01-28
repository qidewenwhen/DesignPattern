interface Human {
	public void eat();
	public void sleep();
	public void play();
}

class Male implements Human {
	public void eat() {
		System.out.println("Male can eat.");
	}
	public void sleep() {
		System.out.println("Male can sleep.");
	}
	public void play() {
		System.out.println("Male can play.");
	}
}

class Female implements Human {
	public void eat() {
		System.out.println("Female can eat.");
	}
	public void sleep() {
		System.out.println("Female can sleep.");
	}
	public void play() {
		System.out.println("Female can play.");
	}
}

class HumanFactory {
	public Human createHuman(String gender) {
		if (gender.equals("Female")) {
			return new Female();
		} else if (gender.equals("Male")) {
			return new Male();
		} else {
			System.out.println("Please input correct type.");
			return null;
		}
	}
	public static Male createMale() {
		return new Male();
	}
	public static Female createFemale() {
		return new Female();
	}
}

public class FactoryTest {
	public static void main(String[] args) {
		// HumanFactory factory = new HumanFactory();
		// Human male = factory.createHuman("Male");
		Human male = HumanFactory.createMale();
		male.eat();
		male.sleep();
		male.play();
	}
}
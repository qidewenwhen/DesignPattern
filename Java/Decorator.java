abstract class Girl {
	String description = "plain";
	public String getDescription() {
		return description;
	}
}

class AmericanGirl extends Girl {
	public AmericanGirl() {
		description = " + AmericanGirl";
	}
}

class ChineseGirl extends Girl {
	public ChineseGirl() {
		description = " + ChineseGirl";
	}
}

abstract class GirlDecorator extends Girl {
	public abstract String getDescription();
}

class GoldenHair extends GirlDecorator {
	private Girl girl;

	public GoldenHair(Girl g) {
		girl = g;
	}

	@Override
	public String getDescription() {
		return girl.getDescription() + " + with golden hair";
	}
}

class Tall extends GirlDecorator {
	private Girl girl;

	public Tall(Girl g) {
		this.girl = g;
	}

	@Override
	public String getDescription() {
		return girl.getDescription() + " + is very tall";
	}
}

public class Decorator {
	public static void main(String[] args) {
		Girl g1 = new AmericanGirl();
		System.out.println(g1.getDescription());

		Girl g2 = new GoldenHair(g1);
		System.out.println(g2.getDescription());

		Girl g3 = new Tall(g2);
		System.out.println(g3.getDescription());
	}
}
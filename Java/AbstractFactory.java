interface Food {
	public String getFoodName();
}

interface TableWare {
	public String getToolName();
}

interface KitchenFactory {
	public Food getFood();
	public TableWare getTableWare();
}

class Apple implements Food {
	public String getFoodName() {
		return "apple";
	}
}

class Knife implements TableWare {
	public String getToolName() {
		return "knife";
	}
}

class KitchenA implements KitchenFactory{
	public Food getFood() {
		return new Apple();
	}
	public TableWare getTableWare() {
		return new Knife();
	}
}

public class AbstractFactory {
	public void eat(KitchenFactory k) {
		System.out.println("I'm having " + k.getFood().getFoodName() + " and " + k.getTableWare().getToolName());
	}

	public static void main(String[] args) {
		AbstractFactory af = new AbstractFactory();
		KitchenFactory kf = new KitchenA();
		af.eat(kf);
	}
}
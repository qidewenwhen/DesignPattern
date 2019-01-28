// class Singleton {
// 	private static final Singleton wife = new Singleton();
// 	private Singleton();
// 	public static Singleton getWife() {
// 		return wife;
// 	}
// }

// public class Singleton {
// 	private volatile static Singleton wife;
// 	private Singleton();
// 	public static Singleton getWife() {
// 		if (wife == null) {
// 			synchronized (Singleton.class) {
// 				if (wife == null) {
// 					wife = new Singleton();
// 				}
// 			}
			
// 		}
// 		return wife;
// 	}
// }

public class Singleton {
	private static class Holder {
		private static final Singleton wife = new Singleton();
	}
	private Singleton();
	public static Singleton getWife() {
		return Holder.wife;
	}
}

// public enum Singleton {
// 	INSTANCE;
// 	public void method() {}
// }
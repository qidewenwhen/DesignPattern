interface CnPluginInterface {
	public void chargeWith2Pins();
}

class CnPlugin implements CnPluginInterface {
	public void chargeWith2Pins() {
		System.out.println("charge with CnPlugin");
	}
}

interface EnPluginInterface {
	public void chargeWith3Pins();
}

class EnPlugin implements EnPluginInterface {
	public void chargeWith3Pins() {
		System.out.println("charge with EnPlugin");
	}
}

class PluginAdapter implements CnPluginInterface {
	private EnPluginInterface enPlugin;
	public PluginAdapter(EnPluginInterface enPlugin) {
		this.enPlugin = enPlugin;
	}

	@Override
	public void chargeWith2Pins() {
		enPlugin.chargeWith3Pins();
	}
}

class Home {
	private CnPluginInterface cnPlugin;

	public Home() {}

	public Home(CnPluginInterface cnPlugin) {
		this.cnPlugin = cnPlugin;
	}

	public void setPlugin(CnPluginInterface cnPlugin) {
		this.cnPlugin = cnPlugin;
	}

	public void charge() {
		cnPlugin.chargeWith2Pins();
	}
}

public class Adapter {
	public static void main(String[] args) {
		EnPluginInterface enPlugin = new EnPlugin();
		Home home = new Home();
		PluginAdapter pluginAdapter = new PluginAdapter(enPlugin);
		home.setPlugin(pluginAdapter);
		home.charge();
	}
}
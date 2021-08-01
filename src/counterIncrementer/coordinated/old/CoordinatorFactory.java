package counterIncrementer.coordinated.old;

public class CoordinatorFactory {
	static Coordinator singleton;
	public static Coordinator getSingleton() {
		if (singleton == null) {
			singleton = new BasicCoordinator();
		}
		return singleton;
	}
}

package coordination.joiner;

public class JoinerFactory {
	static Joiner singleton;
	public static Joiner getSingleton() {
		if (singleton == null) {
			singleton = new BasicJoiner();
		}
		return singleton;
	}
}

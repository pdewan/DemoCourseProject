package coordination.joiner;

public class JoinerFactory {
	static Joiner singleton;
	public static Joiner getSingleton() {
		if (singleton == null) {
			singleton = createNewJoiner();
		}
		return singleton;
	}
	protected static Joiner createNewJoiner() {
		return new BasicJoiner();
	}
}

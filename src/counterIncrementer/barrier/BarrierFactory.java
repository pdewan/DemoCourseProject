package counterIncrementer.barrier;

public class BarrierFactory {
	static Barrier singleton;
	public static Barrier getSingleton(int aNumThreads) {
		if (singleton == null) {
			singleton = new BasicBarrier(aNumThreads);
		}
		return singleton;
	}
}

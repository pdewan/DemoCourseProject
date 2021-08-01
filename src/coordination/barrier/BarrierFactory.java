package coordination.barrier;

public class BarrierFactory {
	static Barrier singleton;
//	public static Barrier getSingleton(int aNumThreads) {
//		if (singleton == null) {
//			singleton = new BasicBarrier(aNumThreads);
//		}
//		return singleton;
//	}
	
	public static Barrier getSingleton() {
		if (singleton == null) {
			singleton = new BasicBarrier();
		}
		return singleton;
	}
}

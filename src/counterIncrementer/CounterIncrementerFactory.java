package counterIncrementer;


import counterIncrementer.coordinated.CoordinatedCounterIncrementer;
import counterIncrementer.synchronize.SynchronizedCounterIncrementer;
import stringCounter.StringCounter;

public class CounterIncrementerFactory {
//	public static CounterIncrementer createCounterIncrementer(
//			StringCounter aCounter, 
//			int aNumIncrements) {
//		return new SynchronizedCounterIncrementer(aCounter, aNumIncrements);
//
//	}
//	public static CounterIncrementer createCounterIncrementer(
//			StringCounter aCounter, 
//			int aNumIncrements,
//			int aNumRequests) {
//		return new SynchronizedCounterIncrementer(aCounter, aNumIncrements);
//
//	}
	
	public static CounterIncrementer createCounterIncrementer(
			StringCounter aCounter, 
			int aNumIncrements,
			long aPauseTime
			) {
		return new CoordinatedCounterIncrementer(aCounter, aNumIncrements, aPauseTime);

	}
//	public static CounterIncrementer createCounterIncrementer(
//			boolean isCoordinator,
//			StringCounter aCounter, 
//			int aNumIncrements) {
//		if (isCoordinator) {
//			return new CoordinatingCounterIncrementer(aCounter, aNumIncrements);
//		} else {
//			return new CoordinatedCounterIncrementer(aCounter, aNumIncrements);
//		}
//
//	}


}

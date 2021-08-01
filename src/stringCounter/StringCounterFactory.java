package stringCounter;

import java.util.ArrayList;
import java.util.List;

public class StringCounterFactory {
	static List<StringCounter> counters = new ArrayList();
	public static StringCounter createStringCounter(String[] aStringCounts) {
		StringCounter retVal = new CyclicCounter(aStringCounts);
		counters.add(retVal);
		return retVal;
	}
	public static List<StringCounter> getCounters() {
		return counters;
	}
}

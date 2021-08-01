package coordination.barrier;

public interface Barrier {
	 void barrier(); 
	 void reset (int aNumThreads);
}

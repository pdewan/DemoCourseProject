package counterIncrementer.coordinated.old;

public interface Coordinator {

	void synchronizedWait();

	void synchronizedNotify();
	
	void synchronizedNotifyAll();


}
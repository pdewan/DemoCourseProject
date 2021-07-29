package counterIncrementer.coordinated;

public interface Coordinator {

	void synchronizedWait();

	void synchronizedNotify();
	
	void synchronizedNotifyAll();


}
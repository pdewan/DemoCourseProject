package pc.graphics;

public interface BoundedBufferView {
	public Line getVertical();
	public Line getHorizontal();
	public Line getDiagonalOne();
	public Line getDiagonalTwo();
	Circle getCircle();
	Line getDiagonalThree();
	Line getDiagonalFour();
	BoundedBuffer<Integer> getBoundedBuffer();
	
}

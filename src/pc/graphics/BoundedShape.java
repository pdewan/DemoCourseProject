package pc.graphics;

public interface BoundedShape extends Locatable {
	
	public int getHeight();
	public int getWidth();
	public void setHeight(int NewHeight);
	public void setWidth(int NewWidth);

}

package pc.graphics;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ABoundedBufferView  implements BoundedBufferView{
	//make observer of aboundedbuffer
	BoundedBuffer<Integer> observable;
	ACircle circle;
	ALine vertical;
	ALine horizontal;
	ALine diagonalOne;
	ALine diagonalTwo;
	ALine diagonalThree;
	ALine diagonalFour;
	
	int INITIAL_X = 420;
	int INITIAL_Y = 175;
	int INITIAL_Width = 350;
	int INITIAL_Height = 350;
	
	int zero = 0;
	int one = 1;
	int two = 2;
	int three = 3;
	int four = 4;
	int five = 5;
	int six = 6;
	int seven = 7;
	
	public ABoundedBufferView() {
		observable = new ABoundedBuffer<Integer>();
		observable.put(zero);
		observable.put(one);
		observable.put(two);
		observable.put(three);
		observable.put(four);
		observable.put(five);
		observable.put(six);
		observable.put(seven);
		
		circle = new ACircle();
		vertical = new ALine();
		horizontal = new ALine();
		diagonalOne = new ALine();
		diagonalTwo = new ALine();
		diagonalThree = new ALine();
		diagonalFour = new ALine();
		
		vertical.setX(INITIAL_X+(INITIAL_Width/2));
		horizontal.setX(INITIAL_X);
		diagonalOne.setX(INITIAL_X+(INITIAL_Width/2));
		diagonalTwo.setX(INITIAL_X+(INITIAL_Width/2));
		diagonalThree.setX(INITIAL_X+(INITIAL_Width/2));
		diagonalFour.setX(INITIAL_X+(INITIAL_Width/2));
		
		vertical.setY(INITIAL_Y);
		horizontal.setY(INITIAL_Y+(INITIAL_Height/2));
		diagonalOne.setY(INITIAL_Y+(INITIAL_Height/2));
		diagonalTwo.setY(INITIAL_Y+(INITIAL_Width/2));
		diagonalThree.setY(INITIAL_Y+(INITIAL_Width/2));
		diagonalFour.setY(INITIAL_Y+(INITIAL_Width/2));
		
		vertical.setHeight(INITIAL_Height);
		horizontal.rotate(48);
		horizontal.setWidth(INITIAL_Width);	
		diagonalOne.setRadius(INITIAL_Height/2);
		diagonalOne.rotate(151);
		diagonalTwo.setRadius(INITIAL_Width/2);
		diagonalTwo.rotate(-8);
		diagonalThree.setRadius(INITIAL_Height/2);
		diagonalFour.setRadius(INITIAL_Width/2);
		diagonalThree.rotate(168);
		diagonalFour.rotate(8);
		
	}
	
	@Override
	public Line getVertical() {
		return vertical;
	}
	
	@Override
	public Line getHorizontal() {
		return horizontal;
	}
	
	@Override
	public Line getDiagonalOne() {
		return diagonalOne;
	}
	
	@Override
	public Line getDiagonalTwo() {
		return diagonalTwo;
	}
	
	@Override
	public Circle getCircle() {
		return circle;
	}
	
	@Override
	public Line getDiagonalThree() {
		return diagonalThree;
	}
	
	@Override
	public Line getDiagonalFour() {
		return diagonalFour;
	}
	
	@Override
	@Visible(false)
	public BoundedBuffer<Integer> getBoundedBuffer() {
		return observable;
	}
	
	public void update(BoundedBuffer<Integer> buffer) {
		System.out.println("Buffer: " + buffer.get());
	}

	
	public static void main(String[] args) {
		BoundedBufferView NewTable = new ABoundedBufferView();
		OEFrame editor = ObjectEditor.edit(NewTable);
		editor.showDrawPanel();
		editor.showTreePanel();
	}
	
	

	
	

	
	
}

package point;
import util.annotations.Explanation;
//@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Explanation("Location in Java coordinate System.")
public interface TestablePoint {
	public int getX(); 
	public int getY(); 	
	public double getAngle(); 
	public double getRadius();
//	void print(String aString, ACPoint aPoint);
	void print();
	TestablePoint translate(int anXDelta, int aYDelta); 
}

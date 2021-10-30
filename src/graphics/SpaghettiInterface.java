package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public interface SpaghettiInterface {

	public String getImageFileName();

	public void setImageFileName(String newVal);

}

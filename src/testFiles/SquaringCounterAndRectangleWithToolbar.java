package testFiles;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.attributes.AttributeNames;

public class SquaringCounterAndRectangleWithToolbar  {
	
	
	public static void main (String[] args) {
		// Let the increment method of SquaringCounterAndRectangle be mapped to a button in the toolbar
		ObjectEditor.setMethodAttribute(SquaringCounterAndRectangle.class, "increment", AttributeNames.TOOLBAR_METHOD, true);
		
		// Let the decrement method of SquaringCounterAndRectangle be mapped to a button in the toolbar

		ObjectEditor.setMethodAttribute(SquaringCounterAndRectangle.class, "decrement", AttributeNames.TOOLBAR_METHOD, true);
		
		// z index fix
		// ShapeObjectAdapter.setUseTreeIndexForZIndex(false);

		// display the object after setting the attributed above
		OEFrame oeFrame = ObjectEditor.edit(new SquaringCounterAndRectangle());

		// show the toolbar
		oeFrame.showToolBar();
		
	}
	
}

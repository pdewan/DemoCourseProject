package point;

import java.net.MalformedURLException;
import java.net.URL;

import gradingTools.comp999.assignment1.testcases.CartesianPointSuite;
import gradingTools.interpreter.AnInterpretingGradableJUnitTest;
import gradingTools.interpreter.AnInterpretingGradableJUnitTopLevelSuite;
import util.trace.Tracer;

public class RunAssignment1TestsOnJavaAssignment {
	public static void main(String[] args) {
		Tracer.showInfo(true);
		URL aURL;
		try {
			aURL = new URL("file:///D:/dewan_backup/Java/DemoCourseLocalBasicChecks/assignmentXYZ/");
			AnInterpretingGradableJUnitTopLevelSuite.runSpecifiedTests(aURL);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		CartesianPointSuite.main(args);
	}

}

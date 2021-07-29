package point;

import java.io.InputStream;
import java.util.Scanner;

import gradingTools.fileIO.TestResourceAsStream;

public class TestResourceAsStreanFromStudentProject {
	public static void main(String args[]) {
		InputStream aStream = TestResourceAsStreanFromStudentProject.class.getClassLoader().getResourceAsStream("/assignmentXYZ/input1.txt");

		TestResourceAsStream.main(args);
		int i = 0;
//		
	}

}

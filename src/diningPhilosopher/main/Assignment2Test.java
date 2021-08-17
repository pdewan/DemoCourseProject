package diningPhilosopher.main;

import grader.basics.execution.BasicProjectExecution;
import gradingTools.comp999.assignment2.Assignment2Suite;
import trace.grader.basics.GraderBasicsTraceUtility;

public class Assignment2Test {
	public static void main (String[] args) {
		// if you want to step through local checks calls to your code set this to false
				BasicProjectExecution.setUseMethodAndConstructorTimeOut(false);

				// if you set this to false, grader steps will not be traced
				GraderBasicsTraceUtility.setTracerShowInfo(true);	
				// if you set this to false, all grader steps will be traced,
				// not just the ones that failed		
				GraderBasicsTraceUtility.setBufferTracedMessages(false);
				// Change this number if a test trace gets longer than 600 and is clipped
				GraderBasicsTraceUtility.setMaxPrintedTraces(600);
				// Change this number if all traces together are longer than 2000
				GraderBasicsTraceUtility.setMaxTraces(2000);
				// Change this number if your process times out prematurely
				BasicProjectExecution.setProcessTimeOut(5);
				// Special call for those who implement the delegating painter
				
				;
		Assignment2Suite.main(args);
	}

}

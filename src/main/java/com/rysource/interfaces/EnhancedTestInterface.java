package com.rysource.interfaces;

public interface EnhancedTestInterface {

	public void onTestFinished(boolean result, String className, String methodName);
	
	public void onTestStarted(String className, String methodName);
	
	public void onTestSuppressed(String className, String methodName);
	
	public void onTestFailure(String className, String methodName, String stack);
	
	public void onTestPassed(String className, String methodName);
	
	public void onExecutionFailure(String className, String methodName, String stack);
}

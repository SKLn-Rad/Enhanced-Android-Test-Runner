package com.rysource.runner;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

import com.rysource.annotations.Setup;
import com.rysource.annotations.SuiteInformation;
import com.rysource.annotations.TestInformation;
import com.rysource.interfaces.EnhancedTestInterface;
import com.rysource.report.ReportGenerator;
import com.rysource.report.TestCase;

import android.app.Activity;
import android.os.Bundle;
import android.test.InstrumentationTestRunner;
import android.util.Log;
import junit.framework.TestSuite;

public abstract class EnhancedTestRunner extends InstrumentationTestRunner {

	private static final String TAG = "EnhancedTestRunner";
	private static final String HEADER = "--- EATR - Version 0.2.0 Alpha ---";

	/*
	 * Abstract Methods
	 */
	public abstract TestSuite getTestSuites();
	public abstract EnhancedTestInterface getTestInterface();
	public abstract Class<?> getSetup();
	
	/*
	 * 
	 */
	private AtomicBoolean listening = new AtomicBoolean(false);
	private EnhancedTestInterface enhancedTestInterface = null;
	private Setup setup;
	
	/*
	 * Stored Fields
	 */
	private String className;
	private String methodName;
	private String stack;
	private boolean result;
	private boolean errorHappened;

	private void resetAttributes() {
		className = "";
		methodName = "";
		stack = "";
		result = false;
		errorHappened = false;
	}

	private void sendStartNotification(Bundle results) {
		className = results.getString(REPORT_KEY_NAME_CLASS);
		methodName = results.getString(REPORT_KEY_NAME_TEST);
		stack = results.getString(REPORT_KEY_STACK);

		if (enhancedTestInterface != null)
		enhancedTestInterface.onTestStarted(className, methodName);
	}

	private void processData(int resultCode, Bundle results) {
		Log.d(TAG, "Processing test data...");
		className = results.getString(REPORT_KEY_NAME_CLASS);
		methodName = results.getString(REPORT_KEY_NAME_TEST);
		stack = results.getString(REPORT_KEY_STACK);
		Class<?> clazz;
		Method[] methods;
		
		try {
			clazz = Class.forName(className);
			methods = clazz.getMethods();
			
			com.rysource.report.TestSuite testSuite = null;
			com.rysource.report.TestCase testCase = null;
			
			if (ReportGenerator.SUITES.containsKey(clazz.getName())) {
				testSuite = ReportGenerator.SUITES.get(clazz.getName());
			} else {
				if (clazz.isAnnotationPresent(SuiteInformation.class)) {
					ReportGenerator.SUITES.put(clazz.getName(), new com.rysource.report.TestSuite(clazz.getAnnotation(SuiteInformation.class)));
				} else {
					Log.e(TAG, "No EnhancedTestSuite annotation found on " + className + ", Using class name.");
					ReportGenerator.SUITES.put(clazz.getName(), testSuite = new com.rysource.report.TestSuite(clazz.getName()));
				}
			}
			
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					if (method.isAnnotationPresent(TestInformation.class)) {
						testCase = new TestCase(result, errorHappened, stack, method.getAnnotation(TestInformation.class));
					} else {
						Log.e(TAG, "No EnhancedTestCase annotation found on " + methodName + ", using method name.");
						testCase = new TestCase(result, errorHappened, stack, methodName);
					}
					
					if (testSuite != null && testCase != null) {
						if (enhancedTestInterface != null) {
							if (!result && !errorHappened) {
								enhancedTestInterface.onTestFailure(className, methodName, stack);
							} else if (!errorHappened) {
								enhancedTestInterface.onTestPassed(className, methodName);
							}
							if (errorHappened) {
								enhancedTestInterface.onExecutionFailure(className, methodName, stack);
							} else {
								enhancedTestInterface.onTestFinished(result, className, methodName);
							}
						}
						
						// TODO - Store Test Result in database
						
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void sendStatus(int resultCode, Bundle results) {
		if (listening.get()) {
			switch (resultCode) {
			case REPORT_VALUE_RESULT_OK:
				result = true;
				processData(resultCode, results);
				break;
				
			case REPORT_VALUE_RESULT_ERROR:
				errorHappened = true;
				result = false;
				processData(resultCode, results);
				break;
				
			case REPORT_VALUE_RESULT_FAILURE:
				result = false;
				processData(resultCode, results);
				break;
				
			case REPORT_VALUE_RESULT_START:
				resetAttributes();
				sendStartNotification(results);
				break;
			}
		}
		super.sendStatus(resultCode, results);
	}

	@Override
	public TestSuite getAllTests() {
		return getTestSuites();
	}

	@Override
	public void callActivityOnStart(Activity activity) {
		if (!listening.get()) {
			Log.i(TAG, HEADER);
			listening.set(true);
		}
		
		// TODO - Add Shutdown Hook
		
		/*
		 * Check Abstract Methods
		 */
		if (setup == null) {
			if (getSetup().isAnnotationPresent(Setup.class)) {
				setup = getSetup().getAnnotation(Setup.class);
				Log.d(TAG, "Setup Annotation was found on classpath");
			} else {
				Log.e(TAG, "No Setup Annotation was found... Did you forget to annotate your runner with this?");
			}
		}
		
		if (enhancedTestInterface == null) {
			if ((enhancedTestInterface = getTestInterface()) != null) {
				Log.d(TAG, "Test Interface found on classpath");
			} else {
				Log.e(TAG, "No Test Interface was found... Did you forget to implement this?");
			}
		}
		
		super.callActivityOnStart(activity);
	}
}

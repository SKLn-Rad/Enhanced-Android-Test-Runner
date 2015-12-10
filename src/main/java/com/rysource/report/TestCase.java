package com.rysource.report;

import com.rysource.annotations.TestInformation;
import com.rysource.annotations.TestInformation.TestPriority;
import com.rysource.annotations.TestInformation.TestType;

public class TestCase {

	private String testName;
	private String testDescription;
	private String expectedBehaviour;

	private TestPriority testPriority;
	private TestType testType;

	private boolean result;
	private boolean error;
	private String stack;

	public TestCase(boolean result, boolean error, String stack, TestInformation etc) {
		this.result = result;
		this.error = error;
		this.stack = stack;

		this.testName = etc.testName();
		this.testDescription = etc.testDescription();
		this.expectedBehaviour = etc.expectedBehaviour();

		this.testPriority = etc.priority();
		this.testType = etc.type();
	}

	public TestCase(boolean result, boolean error, String stack, String name) {
		this.result = result;
		this.error = error;
		this.stack = stack;
		this.testName = name;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public String getExpectedBehaviour() {
		return expectedBehaviour;
	}

	public void setExpectedBehaviour(String expectedBehaviour) {
		this.expectedBehaviour = expectedBehaviour;
	}

	public TestPriority getTestPriority() {
		return testPriority;
	}

	public void setTestPriority(TestPriority testPriority) {
		this.testPriority = testPriority;
	}

	public TestType getTestType() {
		return testType;
	}

	public void setTestType(TestType testType) {
		this.testType = testType;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

}
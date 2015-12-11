package com.rysource.report;

import com.rysource.annotations.TestInformation;
import com.rysource.annotations.TestInformation.TestPriority;
import com.rysource.annotations.TestInformation.TestType;

public class TestCase {

	private String name;
	private String description;
	private String expectedBehaviour;

	private TestPriority priority;
	private TestType type;

	private String result;
	private boolean error;
	private String stack;

	public TestCase(String result, boolean error, String stack, TestInformation etc) {
		this.result = result;
		this.error = error;
		this.stack = stack;

		this.name = etc.testName();
		this.description = etc.testDescription();
		this.expectedBehaviour = etc.expectedBehaviour();

		this.priority = etc.priority();
		this.type = etc.type();
	}

	public TestCase(String result, boolean error, String stack, String name) {
		this.result = result;
		this.error = error;
		this.stack = stack;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpectedBehaviour() {
		return expectedBehaviour;
	}

	public void setExpectedBehaviour(String expectedBehaviour) {
		this.expectedBehaviour = expectedBehaviour;
	}

	public TestPriority getPriority() {
		return priority;
	}

	public void setPriority(TestPriority priority) {
		this.priority = priority;
	}

	public TestType getType() {
		return type;
	}

	public void setType(TestType type) {
		this.type = type;
	}

	public String isResult() {
		return result;
	}

	public void setResult(String result) {
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
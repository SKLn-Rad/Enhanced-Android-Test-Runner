package com.rysource.report;

import java.util.ArrayList;

import com.rysource.annotations.SuiteInformation;
import com.rysource.annotations.SuiteInformation.SuitePriority;

public class TestSuite {

	private ArrayList<TestCase> testCases = new ArrayList<TestCase>();

	private String name;
	private String description;
	private SuitePriority priority;
	private String[] acceptanceCriteria;

	public TestSuite(SuiteInformation ets) {
		this.name = ets.suiteName();
		this.description = ets.suiteDescription();
		this.priority = ets.priority();
		this.acceptanceCriteria = ets.suiteAcceptanceCriteria();
	}
	
	public TestSuite(String name) {
		this.name = name;
	}

	public void addTestCase(TestCase testCase) {
		if (this.testCases != null) {
			testCases.add(testCase);
		}
	}

	public ArrayList<TestCase> getTestCases() {
		return testCases;
	}

	public void setTestCases(ArrayList<TestCase> testCases) {
		this.testCases = testCases;
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

	public SuitePriority getPriority() {
		return priority;
	}

	public void setPriority(SuitePriority priority) {
		this.priority = priority;
	}

	public String[] getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String[] acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

}
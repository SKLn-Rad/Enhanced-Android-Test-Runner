package com.rysource.report;

import java.util.ArrayList;

import com.rysource.annotations.SuiteInformation;
import com.rysource.annotations.SuiteInformation.SuitePriority;

public class TestSuite {

	private ArrayList<TestCase> testCases = new ArrayList<TestCase>();

	private String suiteName;
	private String suiteDescription;
	private SuitePriority suitePriority;
	private String[] suiteAcceptanceCriteria;

	public TestSuite(SuiteInformation ets) {
		this.suiteName = ets.suiteName();
		this.suiteDescription = ets.suiteDescription();
		this.suitePriority = ets.priority();
		this.suiteAcceptanceCriteria = ets.suiteAcceptanceCriteria();
	}

	public TestSuite(String name) {
		this.suiteName = name;
	}

	public ArrayList<TestCase> getTestCases() {
		return this.testCases;
	}

	public void addTestCase(TestCase testCase) {
		testCases.add(testCase);
	}

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public String getSuiteDescription() {
		return suiteDescription;
	}

	public void setSuiteDescription(String suiteDescription) {
		this.suiteDescription = suiteDescription;
	}

	public SuitePriority getSuitePriority() {
		return suitePriority;
	}

	public void setSuitePriority(SuitePriority suitePriority) {
		this.suitePriority = suitePriority;
	}

	public String[] getSuiteAcceptanceCriteria() {
		return suiteAcceptanceCriteria;
	}

	public void setSuiteAcceptanceCriteria(String[] suiteAcceptanceCriteria) {
		this.suiteAcceptanceCriteria = suiteAcceptanceCriteria;
	}

	public void setTestCases(ArrayList<TestCase> testCases) {
		this.testCases = testCases;
	}

}
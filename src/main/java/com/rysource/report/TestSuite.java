package com.rysource.report;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.rysource.annotations.SuiteInformation;
import com.rysource.annotations.SuiteInformation.SuitePriority;

public class TestSuite {

	private ArrayList<TestCase> testCases = new ArrayList<TestCase>();

	private String name;
	private String description;
	private SuitePriority priority;
	private String[] acceptanceCriteria;

	private Timestamp timestamp;

	public TestSuite(SuiteInformation ets) {
		this.name = ets.suiteName();
		this.description = ets.suiteDescription();
		this.priority = ets.priority();
		this.acceptanceCriteria = ets.suiteAcceptanceCriteria();
		this.timestamp = new Timestamp(new Date().getTime());
	}
	
	public TestSuite(String name) {
		this.name = name;
		this.timestamp = new Timestamp(new Date().getTime());
	}

	public String getSkippedCount() {
		int skippedCount = 0;
		for (TestCase testCase : testCases) {
			if (testCase.isSuppressed())
				skippedCount++;
		}
		return String.valueOf(skippedCount);
	}
	
	public String getErrorCount() {
		int errorCount = 0;
		for (TestCase testCase : testCases) {
			if (testCase.isError())
				errorCount++;
		}
		return String.valueOf(errorCount);
	}

	public String getFailureCount() {
		int failureCount = 0;
		for (TestCase testCase : testCases) {
			if (testCase.isResult().equals("Failed"))
				failureCount++;
		}
		return String.valueOf(failureCount);
	}

	public String getPassedCount() {
		int passedCount = 0;
		for (TestCase testCase : testCases) {
			if (testCase.isResult().equals("Passed"))
				passedCount++;
		}
		return String.valueOf(passedCount);
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

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
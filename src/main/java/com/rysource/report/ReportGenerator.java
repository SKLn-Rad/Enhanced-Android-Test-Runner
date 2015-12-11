package com.rysource.report;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.rysource.annotations.Setup;
import com.rysource.annotations.Setup.ReportType;

import android.os.Environment;
import android.util.Log;

/**
 * INTERNAL USE ONLY.
 * This class is the thread spawned on death of the test harness and is used to generate reports to the user.
 * @author ryandixon1993@gmail.com
 */
public class ReportGenerator extends Thread {

	private static Setup setup;
	
	private static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
	private static File outputFile;
	
	public static final HashMap<String, TestSuite> SUITES = new HashMap<String, TestSuite>();

	private static final String TAG = "ReportGenerator";
	
	public ReportGenerator(Setup setup) {
		ReportGenerator.setup = setup;
		start();
	}
	
	@Override
	public synchronized void start() {
		// Detect Settings for Report Type
		Log.i(TAG, "Finished testing. getting reportable data from annotations...");
		if (SUITES == null) {
			Log.e(TAG, "Something went wrong, could not generate report.");
			return;
		}
		
		Log.d(TAG, "Preparing report...");
		
		prepareReport();
		super.start();
	}

	private static void prepareFilePath(String reportName) {
		Log.d(TAG, "Preparing new report");
		if (new File(path + reportName).exists()) {
		Log.i(TAG, "Found old test, deleting.");
			new File(path).delete();
		}
		
		Log.i(TAG, "Outputting report to " + new File(path).getAbsolutePath() + File.separator + reportName);
		outputFile = new File(path + reportName);

		try {
			outputFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void prepareReport() {
		for (ReportType report : setup.reportType()) {
			switch (report) {
			case JUNIT_XML:
				break;
			default:
				break;
			}
		}
	}
	
	public static Setup getSetup() {
		return ReportGenerator.setup;
	}
	
}

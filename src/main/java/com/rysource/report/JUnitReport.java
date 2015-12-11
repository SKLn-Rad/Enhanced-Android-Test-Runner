package com.rysource.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.xmlpull.v1.XmlSerializer;

import android.util.Log;
import android.util.Xml;

public class JUnitReport {

	private static final String TAG = "JUnitReport";
	
	public static void generateJUnitReport(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			XmlSerializer xmlSerializer = Xml.newSerializer();
			StringWriter writer = new StringWriter();
			xmlSerializer.setOutput(writer);
			xmlSerializer.startDocument("UTF-8", true);
			
			getTestData(xmlSerializer);
			
			xmlSerializer.endDocument();
			xmlSerializer.flush();
			fos.write(writer.toString().getBytes());
			fos.close();
			Log.i(TAG, "Finished Writing XML file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getTestData(XmlSerializer xmlSerializer) {
		try {
			xmlSerializer.startTag(null, "testsuites");
			
			Iterator<?> iter = ReportGenerator.SUITES.entrySet().iterator();
			while (iter.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, TestSuite> pair = (Entry<String, TestSuite>) iter.next();
				TestSuite suite = pair.getValue();
				
				xmlSerializer.startTag(null, "testsuite");
				xmlSerializer.attribute(null, "name", suite.getName());
				xmlSerializer.attribute(null, "errors", suite.getErrorCount());
				xmlSerializer.attribute(null, "skipped", suite.getSkippedCount());
				
				// TODO - Measure Test Time
				xmlSerializer.attribute(null, "time", "0");
				xmlSerializer.attribute(null, "timestamp", String.valueOf(suite.getTimestamp()));
				
				xmlSerializer.attribute(null, "tests", String.valueOf(suite.getTestCases().size()));
				xmlSerializer.endTag(null, "testsuite");
			}
			
			xmlSerializer.endTag(null, "testsuites");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

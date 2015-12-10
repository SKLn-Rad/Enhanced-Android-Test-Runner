package com.rysource.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestInformation {

	public enum TestPriority {
		NONE, LOW, MEDIUM, HIGH, CRITICAL
	}

	public enum TestType {
		MANUAL, AUTOMATIC
	}

	TestPriority priority() default TestPriority.MEDIUM;

	TestType type() default TestType.AUTOMATIC;

	String testName() default "Unknown test case";

	String testDescription() default "No description given";

	String expectedBehaviour() default "No expected behaviour supplied";

}

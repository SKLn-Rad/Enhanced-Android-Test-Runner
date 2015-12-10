package com.rysource.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SuiteInformation {

	public enum SuitePriority {
		NONE, LOW, MEDIUM, HIGH, CRITICAL
	}

	SuitePriority priority() default SuitePriority.MEDIUM;

	String suiteName() default "Unknown test suite";

	String suiteDescription() default "No description given";

	String[] suiteAcceptanceCriteria() default {};
}

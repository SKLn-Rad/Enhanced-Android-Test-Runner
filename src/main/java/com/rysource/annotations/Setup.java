package com.rysource.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Setup {

	public enum ReportType {
		EXCEL_REPORT
	}

	ReportType[] reportType() default {};

	String apiKey() default "";

	String application() default "Unknown Application";

	String version() default "Unknown Version";

	String[] features() default {};

	String[] knownDefects() default {};

	int attempt() default 1;

	boolean retainSuppressedTests() default true;
}

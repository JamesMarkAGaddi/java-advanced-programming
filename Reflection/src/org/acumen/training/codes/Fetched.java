package org.acumen.training.codes;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Fetched {

	String kind();// this is not amethod, but a field

	int[] data();// mga required fields to

	// default fields
	String company() default "SBC";

	// constants
	double accessRate = 0.10;

}

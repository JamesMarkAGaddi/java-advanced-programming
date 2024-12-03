package org.acumen.training.codes.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
//@SelectPackages(value = "org.acumen.training.codes") //pwedeng naka array of packages
//pwedeng include exclude packages pag mapili

@SuiteDisplayName("Sample JUnit Test")
@SelectClasses(value = { TestMathematics.class, TestSavingsRepository.class })
public class SuiteTestExecution {

}

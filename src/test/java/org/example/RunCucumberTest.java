package org.example;


import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Cucumber tests")
@SelectPackages("org.example")
@IncludeClassNamePatterns(".*Stepdefs")
public class RunCucumberTest {}

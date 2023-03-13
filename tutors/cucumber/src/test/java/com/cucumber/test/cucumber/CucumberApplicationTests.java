package com.cucumber.test.cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features")
class CucumberApplicationTests extends AbstractTestNGCucumberTests {

}

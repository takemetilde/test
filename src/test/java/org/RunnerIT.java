package org;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "org.steps",
        plugin = {"pretty", "html:target/reports/HtmlReports", "json:target/reports/cucumber-report.json"})
public class RunnerIT
{
}

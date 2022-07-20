package com.nextbase.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty", "html:target/cucumber_reports.html", "json:target/cucumber-report.json", "me.jvt.cucumber.report.PrettyReports:target", "rerun:target/rerun.txt"},
        features ="src/test/resources/features",
        glue ="com/nextbase/step_defs",
        dryRun = true,
        publish = true,
        tags = "@wip"
)

public class CukesRunner {

}

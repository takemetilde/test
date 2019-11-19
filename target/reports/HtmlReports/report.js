$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/Test.feature");
formatter.feature({
  "name": "Testing OOP",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing inheritance",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "print BaseImpl string",
  "keyword": "Then "
});
formatter.match({
  "location": "BaseSteps.return_baseimpl_string()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "print concrete string after setting base string",
  "keyword": "Then "
});
formatter.match({
  "location": "ConcreteSteps.return_concrete_1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "print BaseImpl string",
  "keyword": "Then "
});
formatter.match({
  "location": "BaseSteps.return_baseimpl_string()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("classpath:features/Test2.feature");
formatter.feature({
  "name": "Testing OOP 2",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing inheritance",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "print BaseImpl string",
  "keyword": "Then "
});
formatter.match({
  "location": "BaseSteps.return_baseimpl_string()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "print concrete string after setting base string",
  "keyword": "Then "
});
formatter.match({
  "location": "ConcreteSteps.return_concrete_1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "print BaseImpl string",
  "keyword": "Then "
});
formatter.match({
  "location": "BaseSteps.return_baseimpl_string()"
});
formatter.result({
  "status": "passed"
});
});
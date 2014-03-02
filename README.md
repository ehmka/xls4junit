#xls4junit

This is an example how you can use JUNIT's paramaterized Tests for creating multiple testcases from one excel row. The
result the first call created are used for the second call. They are stored in a static map. This is just a Proof of
concept. If you want to use it you should define some types which make it easier to use do the correct calls.

* ExcelTestWithStateTest.java - state is shared between different calls
* ExcelTestAdvancedTest.java - different methods will be called from one excel row
* ExcelTestSimple.java - tests are generated from excel
* ParameterTest.java - shows how to use paramterized tests
* NoExcelTest.java - simple test no paramaters are used

##Helpers
* ReadCsvTest.java - shows how to use http://code.google.com/p/jcsv/
* ApiTest - minimal test for dummy api, which will be testet
package serasa.suites;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import serasa.knnarTests.KnnarParameteresTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({KnnarParameteresTest.class})
public class knnarSuite {

} ;



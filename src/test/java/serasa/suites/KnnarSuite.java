package serasa.suites;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import serasa.knnarTests.KnnarParameteresTest;


public class KnnarSuite {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(KnnarParameteresTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
package problem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import problem.blueberrymuffin.MuffinThreadExecutorTest;
import problem.blueberrymuffin.RealThreadTest;
import problem.blueberrymuffin.VirtualThreadTest;
import problem.blueberrymuffinclient.MuffinAppIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({
	RealThreadTest.class,
	VirtualThreadTest.class,
	MuffinThreadExecutorTest.class,
	MuffinAppIntegrationTest.class
})
public class AllTests {
}

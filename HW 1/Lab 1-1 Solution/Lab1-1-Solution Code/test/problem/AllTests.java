package problem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AmazonLineParserTest.class,
	DataStandardizerIntergrationTest.class, 
	GoogleLineParserTest.class,
	MicrosoftLineParserTest.class 
})
public class AllTests {

}

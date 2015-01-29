package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSample()
	{
		//fail("This is a failing test");
		//assertTrue("This is false", isGreaterThan(5,6));
		assertEquals("5 is equal to 5",5,5);
	}
	
	public void testEquals() {
		Date date = new Date();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello", new Date(123));
		NormalTweetModel tweet2 = new NormalTweetModel("Hello", new Date(123));
		assertTrue("Different tweets are different", tweet1.equals(tweet2));
	}
	

	public void testEqualsImportantTweet() {
		Date date = new Date();
		String commonDescription = "Hello";
		ImportantTweetModel tweet1 = new ImportantTweetModel(commonDescription, date);
		ImportantTweetModel tweet2 = new ImportantTweetModel(commonDescription, date);
		assertTrue(tweet1.equals(tweet2));
		assertTrue(tweet2.equals(tweet1));
	}

	public void testNotEqualsImportantTweet() {
		String commonDescription = "Hello";
		ImportantTweetModel tweet1 = new ImportantTweetModel(commonDescription, new Date(123));
		ImportantTweetModel tweet2 = new ImportantTweetModel(commonDescription, new Date(321));
		assertFalse(tweet1.equals(tweet2));
		assertFalse(tweet2.equals(tweet1));
		Date date = new Date();
		tweet1 = new ImportantTweetModel("Hi", date);
		tweet2 = new ImportantTweetModel("There", date);
		assertFalse(tweet1.equals(tweet2));
		assertFalse(tweet2.equals(tweet1));
	}
	
	public void testImportantTweetAndNormalTweetNotEqual() {
		Date date = new Date();
		String commonDescription = "Hello";
		NormalTweetModel tweet1 = new NormalTweetModel(commonDescription, date);
		ImportantTweetModel tweet2 = new ImportantTweetModel(commonDescription, date);
		assertFalse(tweet1.equals(tweet2));
		assertFalse(tweet2.equals(tweet1));
	}

	private boolean isGreaterThan(int i, int j) {
		if(i>j)
			return true;
		else
			return false;
	}

}

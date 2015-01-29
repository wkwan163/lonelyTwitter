package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetList;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListTests extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListTests() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testTweetList() {
		TweetList tweetlist = new TweetList();
		ArrayList<LonelyTweetModel> tweets = tweetlist.getTweets();
		assertNotNull("Tweet List not initialised", tweetlist.getTweets());
	}
	
	public void testCounts() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweetList.addTweet(tweet);
		assertEquals("This should be one", 1, tweetList.getCounts());
	}
	
	 public void testAddSameTweet() {
		 TweetList tweetList = new TweetList();
		 NormalTweetModel tweet = new NormalTweetModel("Hello");
		 tweetList.addTweet(tweet);
		 try {
		 // Should fail the second time
			 tweetList.addTweet(tweet);
			 fail("Missing exception");
		 } catch (IllegalArgumentException e) {
			 }
		 }

	 public void testTweetsKeepOrder() {
		 TweetList tweetList = new TweetList();
		 NormalTweetModel tweet1 = new NormalTweetModel("Hello", new Date(1));
		 NormalTweetModel tweet2 = new NormalTweetModel("Hiya", new Date(30));
		 NormalTweetModel tweet3 = new NormalTweetModel("Bob", new Date(60));
		 tweetList.addTweet(tweet1);
		 tweetList.addTweet(tweet3);
		 tweetList.addTweet(tweet2);
		 ArrayList<LonelyTweetModel> tweets = tweetList.getTweets();
		 assertEquals(tweet1, tweets.get(0));
		 assertEquals(tweet2, tweets.get(1));
		 assertEquals(tweet3, tweets.get(2));
		 }
	 
	 public void testHasTweet() {
		 TweetList tweetList = new TweetList();
		 NormalTweetModel tweet = new NormalTweetModel("Hello");
		 assertFalse(tweetList.hasTweet(tweet));
		 tweetList.addTweet(tweet);
		 assertTrue(tweetList.hasTweet(tweet));
		 NormalTweetModel otherTweet = new NormalTweetModel("H");
		 assertFalse(tweetList.hasTweet(otherTweet));
		 }
	 
	 public void testRemoveTweet() {
		 TweetList tweetList = new TweetList();
		 NormalTweetModel removedTweet = new NormalTweetModel("Hello");
		 NormalTweetModel keptTweet = new NormalTweetModel("H");
		 // Should not crash
		 tweetList.removeTweet(removedTweet);
		 tweetList.addTweet(removedTweet);
		 tweetList.addTweet(keptTweet);
		 tweetList.removeTweet(removedTweet);
		 assertTrue(tweetList.hasTweet(keptTweet));
		 assertFalse(tweetList.hasTweet(removedTweet));
		 }
}
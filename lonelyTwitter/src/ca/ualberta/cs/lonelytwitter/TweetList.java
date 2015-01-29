package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetList {
	
	private ArrayList<LonelyTweetModel> tweetList;
	private int count;
	
	public TweetList()
	{
		tweetList = new ArrayList<LonelyTweetModel>();
		count = 0;
	}
	
	public ArrayList<LonelyTweetModel> getTweets() {
		return tweetList;
	}
	
	public int getCounts() {
		return count;
	}
	
	public void addTweet(LonelyTweetModel tweet) {
		count++;
		tweetList.add(tweet);
	}
	
	 public ArrayList<LonelyTweetModel> getTweets() {
		 Collections.sort(tweetList, new Comparator<LonelyTweetModel>() {
		 public int compare(LonelyTweetModel arg0, LonelyTweetModel arg1) {
		 return arg0.getTimestamp().compareTo(arg1.getTimestamp());
		 }
		 });
		 return tweetList;
		 }
		 public int getCount() {
		 return tweetList.size();
		 }
		 public void addTweet(LonelyTweetModel tweet) {
		 if (tweetList.contains(tweet))
		 throw new IllegalArgumentException("Cannot contain same tweet");
		 tweetList.add(tweet);
		 }
		 public boolean hasTweet(LonelyTweetModel tweet) {
		 return tweetList.contains(tweet);
		 }
		 public void removeTweet(LonelyTweetModel tweet) {
		 tweetList.remove(tweet);
		 }

}

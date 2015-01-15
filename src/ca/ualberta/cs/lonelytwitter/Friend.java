package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Friend implements FriendStatus {
	private String friendname;
	
	public String getFriendname() {
		return friendname;
	}
	
	public void setFriendname(String x) throws IOException {
		if (x.length() > 20) {
			throw new IOException("Name is too long!");
			}
			this.friendname = x;
		}
	
	public Friend(String a) {
		super();
		this.friendname = a;
	}
}

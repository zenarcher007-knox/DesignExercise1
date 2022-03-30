import java.util.TreeSet;

public class User implements Comparable<User> {
  private TreeSet<User> followerList;
  private String name;
  
  public User(String name) {
    followerList = new TreeSet<User>();
    this.name = name;
  }
  
  /* Print as the name */
  @Override
  public String toString() {
    return name;
  }
  
  /* Sends a message to all followers, and reads their reply. In a real-world
   * situation, this might add the message to a persistent "feed," visible to one's followers. */
  public void post(String message) {
    int followerCount = followerList.size();
    System.out.println("    " + name + " --> " + followerCount + " follower" + addS(followerCount) + ": \"" + message + "\"");
    for(User u : followerList) {
      Tweet twt = new Tweet(this, message); // Sender, message
      String reply = u.sendMessage(twt);
      System.out.println(reply);
    }
  }
  
  
  public String getName() {
    return name;
  }
  
  /* Adds this user to the other user's follower list. Does nothing if it already exists. */
  public void follow(User u) {
    System.out.println("    " + name + " is now following " + u.getName() + "!");
    u.addFollower(this);
  }
  
  /* Removes this user to the other user's follower list. Does nothing if it doesn't exist. */
  public void unfollow(User u) {
    System.out.println("    " + name + " is no longer following " + u.getName() + "!");
    u.delFollower(this);
  }
  
  
  
  
  
  /* Methods not for public use:  (if only Java had Friend class methods...) */
  
  /* To be called by a user following another user. If only Java had friend class methods... */
  public void addFollower(User u) {
    followerList.add(u);
  }
  
  /* To be called by a user unfollowing another user. If only Java had friend class methods... */
  public void delFollower(User u) {
    followerList.remove(u);
  }

  @Override
  public int compareTo(User o) {
    return name.compareTo(o.getName());
  }

  /* To enhance debugging messages */
  private String addS(int number) {
    if(number == 1)
      return "";
    else
        return "s";
  }
  
  /* To be called by other posting users. */
  public String sendMessage(Tweet twt) {
    return this + " liked " + twt.readSender() + "'s post: \"" + twt.readMessage() + "\"";
  }
}

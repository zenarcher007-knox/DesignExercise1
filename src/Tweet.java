/* A message that can be sent or received by Users. Note that this
 * only represents a message in transport over the internet... */
public class Tweet {
  private User sender;
  private String message;
  
  public Tweet(User sender, String message) {
    this.message = message;
    this.sender = sender;
  }
  
  public User readSender() {
    return this.sender;
  }
  
  public String readMessage() {
    return this.message;
  }
}

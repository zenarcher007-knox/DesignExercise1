
public class TestDriver {

  /* Simulates a social networking conversation. Assumes that all users will instantly like
   * anything each other post. I don't know if Twitter allows the person being followed to be
   * notified of anything they post, the other way around from followers receiving messages from
   * people you follow (i.e. people you follow automatically add you as a follower back.
   * I don't use social media, but I think that's how YouTube's "subscribe" 
   * works. I assumed it was like YouTube. */
	public static void main(String[] args) {
	  
		User John = new User("John");
		User Justin = new User("Justin");
		User Jacob = new User("Jacob");
		User Jacomb = new User("Jacomb");
	  
		Justin.post("Hello");
	  
	  Jacob.follow(Justin);
	  Justin.post("I saw a nuthatch today");
	  Jacob.post("Cool.");
	  
	 Jacob.post("Can anybody hear me? I guess not. I have no followers :(");
	 Justin.follow(Jacob);
	 Jacob.post("Yay!");
	 Justin.post("Oops, clicked the wrong button! Sorry, meant to follow the other guy!");
	 Justin.unfollow(Jacob);
	 Jacob.post("Awwwww :(");
	 
	 Justin.follow(John);
	 Jacomb.follow(John);
	 John.post("Hi there!");
	 Jacomb.post("Hello, can you hear me?");
	 John.follow(Jacomb);
	 Jacomb.post("Now can anyone hear me?");
	 Jacomb.post("I can hear you now,");
	 
	 Jacob.follow(Jacomb); // *Jacomb sees that Jacob is a new follower, and follows him back.*
	 Jacomb.follow(Jacob);
	 
	 Jacob.follow(Jacomb);
	 Jacob.post("Oops, clicked it twice. Did I do something wrong? Will anything bad happen?");
	 Jacomb.post("Don't worry, it should be fine as long as this system was designed corrrectly.");
	 
	 Jacomb.post("My favorite color is a very very dark turquoise.");
	 Jacob.post("Ugh, I hate very very dark turquoise. I'm leaving!");
	 Justin.post("I think it's okay.");
	 
	 /*Vigorously spams the "unfollow" button*/
	 for(int i = 0; i < 10; ++i)
	   Jacob.unfollow(Jacomb);
	 Jacomb.post("Weirdo.");
	 
	 John.follow(Jacob);
	 John.follow(Justin);
	 John.follow(Jacomb);
	 
	 Jacomb.post("Bye!");
	 John.post("Bye!");
	 Justin.post("Bye!");
   
	 
	 
	}

}

package hw2;

public class player {
	private 
	String username;
	int score;
	
	public
	player(String username, int score){
		this.username=username;
		this.score = score;
	}
	
	String returnUsername(){
		return this.username;
	}
	
	int returnScore(){
		return score;
	}
}

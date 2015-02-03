package hw2;

import java.util.Comparator;

public class PlayerScoreComparator implements Comparator<player> {
	public int compare(player p1, player p2){
		if(p1.returnScore()<=p2.returnScore()){
			return -1;
		}
		else if(p1.returnScore()>p2.returnScore())
		{
			return 1;
		}
		return 0;
	}
}

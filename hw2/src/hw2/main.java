package hw2;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class main {
	 static boolean [][] map_test = new boolean [10][10];
	 //set up the map 2 D array
	 static  char[][] map = new char[10][10];
	 static BattleshipGUI bsg = new BattleshipGUI();
	  
	public static void main(String[] args) {
		
		//Priority Queue Set Up
		  Comparator<player> comparator = new PlayerScoreComparator();
	      PriorityQueue<player> queue =  new PriorityQueue<player>(20, comparator);
	      
	      
		// TODO Auto-generated method stub
		System.out.println("Welcome to Battleship game field");
		Scanner scan = new Scanner(System.in);
		int file_format_indicator = 0 ;
		boolean user_ranking = true;
		//ask user to input the filename
		while(file_format_indicator == 0)
			{
			  try{
				  System.out.println("Please input the name of the battleship game file\n");
				  String file_name = scan.nextLine() ;
				  FileReader fr = new FileReader("bs.txt");
				  BufferedReader br = new BufferedReader(fr);
				  file_format_indicator = 1;
				  String line = br.readLine();
				  //System.out.println(line);
				  
				  //reading the user ranking information 
				  while(line!= null && user_ranking){
				
					  if(line.equals("Highscores:")){
						  System.out.println(line);
					  }
					  else if(!line.equals("Highscores:")){
						  System.out.println(line);
						  String [] separated = line.split(" ");
						  //System.out.println(Arrays.toString(separated));
						  
						  //if condition for empty array
						  if(separated.length!= 1)
						  {
							  player p = new player(separated[1],Integer.parseInt(separated[2]));
						      //priority queue
						      queue.add(p);  
						  }
			              
						  //if condition for the end of the array
					      if(separated[0].equals("10.")){
					    	  user_ranking = false;
					    	  break;
					      }
					  } 
					  line = br.readLine();
				  }
				  
				
				 //reading the map
				  int mapline = 0;
				  //line = br.readLine();
				  String line_map;
					  for(int a = 0 ; a< 10 ; a++){
						  line_map = br.readLine();
						  System.out.println(line_map);
						  for(int b = 0 ; b <10 ; b++)
						  {
							  map [a][b] = line_map.charAt(b);
						  }
					  }	  
					   
				  
				  //check to see the map is right 
				  int a_count = 0; boolean a_bool = true;
				  int b_count = 0; boolean b_bool = true;
				  int c_count = 0; boolean c_bool = true;
				  int d_count = 0; boolean d_bool = true;
				  				  
				  for(int c = 0 ; c < 10 ; c++)
				  { 
					  for(int d = 0; d < 10; d++)
					  {
						  
						  //test the position of ship A
						  if(map[c][d] == 'A' && !map_test[c][d])
						  {		  //System.out.println("A_bool is true");
							  int A_count = 1;
							  map_test[c][d] = true;
							  
							  
							  if(map[c+1][d] == 'A' && !map_test[c+1][d]){
								  
								  A_count += 1;
								  map_test[c+1][d] = true;
								  //call the boolean function to check if the ship A location is right
								  a_bool = ship_format_testing_down(5,c,d,'A');	
								  if(a_bool){
									  System.out.println("A_bool is true");
									  a_count += 1;
								  }
								  
							  }
						      else if(map[c][d+1] == 'A' && !map_test[c][d+1])
							  {
								  
								  A_count += 1;
								  map_test[c][d+1] = true;
								  a_bool = ship_format_testing_right(5,c,d,'A');
								  if(a_bool){
									  System.out.println("A_bool is true");
									  a_count += 1;
								  }
							  }
						  }
						  //test the condition of B
						  else if(map[c][d] == 'B' && !map_test[c][d])
						  {
							  //System.out.println("B_bool is true ..");
							  int B_count = 1;
							  map_test[c][d] = true;
							  
							  
							  if(map[c+1][d] == 'B' && !map_test[c+1][d]){
								  
								  B_count += 1;
								  map_test[c+1][d] = true;
								  //call the boolean function to check if the ship B location is right
								  b_bool = ship_format_testing_down(4,c,d,'B');	
								  if(b_bool){
									  System.out.println("B_bool is true");
									  b_count += 1;
								  }
								  
							  }
						      else if(map[c][d+1] == 'B' && !map_test[c][d+1])
							  {
								  B_count += 1;
								  map_test[c][d+1] = true;
								  b_bool = ship_format_testing_right(4,c,d,'B');
								  if(b_bool){
									  System.out.println("B_bool is true");
									  b_count += 1;
								  }
							  }
						  }
						  
						  //test the condition of C
						  else if(map[c][d] == 'C' && !map_test[c][d])
						  {
							  //System.out.println("C_bool is true ..");
							  int C_count = 1;
							  map_test[c][d] = true;
							  
							  
							  if(map[c+1][d] == 'C' && !map_test[c+1][d]){
								  
								  C_count += 1;
								  map_test[c+1][d] = true;
								  //call the boolean function to check if the ship B location is right
								  c_bool = ship_format_testing_down(3,c,d,'C');	
								  if(c_bool){
									  System.out.println("C_bool is true");
									  c_count += 1;
								  }
								  
							  }
						      else if(map[c][d+1] == 'C' && !map_test[c][d+1])
							  {
								  C_count += 1;
								  map_test[c][d+1] = true;
								  c_bool = ship_format_testing_right(3,c,d,'C');
								  if(c_bool){
									  System.out.println("C_bool is true");
									  c_count += 1;
								  }
							  }
						  }
						  
						  //test the condition of D
						  else if(map[c][d] == 'D' && !map_test[c][d] )
						  {
							  //System.out.println("D_bool is true ..");
							  int D_count = 1;
							  map_test[c][d] = true;
							  
							  
							  if(map[c+1][d] == 'D' && !map_test[c+1][d]){
								  
								  D_count += 1;
								  map_test[c+1][d] = true;
								  //call the boolean function to check if the ship B location is right
								  d_bool = ship_format_testing_down(2,c,d,'D');	
								  if(d_bool){
									  System.out.println("D_bool is true");
									  d_count += 1;
								  }
								  
							  }
						      else if(map[c][d+1] == 'D' && !map_test[c][d+1])
							  {
								  D_count += 1;
								  map_test[c][d+1] = true;
								  d_bool = ship_format_testing_right(2,c,d,'D');
								  if(d_bool){
									  System.out.println("D_bool is true");
									  d_count += 1;
									  
								  }
							  }
						  }
					  }
					 }
					br.close();
					fr.close();  
					 
					if(a_count==1 && b_count ==1 && c_count ==1 && d_count==2){
							 System.out.println("The number of ship is qualified to requirement");
						 }
					else{
					         System.out.println("The number of ship isn't qualified to requirement");
					}
					
			  }catch(FileNotFoundException fnfe) {
				  System.out.println("The file isn't found, please input another file");
				  }catch (IOException ioe) {
				  System.out.println("IOSException occurs, please try again");
			  }
		}
		scan.close();
		
		//starting the game board building 
		
		bsg.showToUser();

 }
	
	static boolean ship_format_testing_right(int size, int x, int y,char symbol)	{
		int count_temp = 2;
		while(count_temp != size)
		  {
			  for(int e = 2 ; e < size; e++)
			  {
				  //System.out.println(map[x+e][y]);
			  
				  if(map[x][y+e] != symbol)
				  {
				  	return false;
				  }
				  else
				  {
					  count_temp += 1;
				  }
			  }
		  }
		
		return true;
	}
	
	
    static boolean ship_format_testing_down(int size,int x, int y, char symbol)	{
    	int count_temp1 = 2;
		while(count_temp1 != size)
		  {
			  for(int e = 2 ; e < size; e++)
			  {
				  if(map[x+e][y] != symbol)
				  {

					  return false;
				  }
				  else
				  {
					  count_temp1 += 1;
				  }
			  }
		  }
		return true;
	}

}

package hw1;

import java.util.Scanner;

public class MainClass {
	public 
	static int choice = 0;
	static ThreeDimension p1 ;
	static ThreeDimension p2 ;
	static String identity;
	VectorClass v1 ;
	VectorClass v2 ;
	static double x= 0 ;
	static double y = 0;
	static double z= 0 ;
	
	//function to check to see if the input format is correct
	public static int FormatChecking(String input){
		String a =input.substring(0, 1); 
		if(a.equals("<"))
		{
			String b = input.substring(1,2);
			//test to see if the first number is double
			if(isDouble(b))
			{
				String c = input.substring(2, 3);
				if(c.equals(">"))
				{
					return 1;
				}
				else if(c.equals(","))
				{
					
					String d = input.substring(3, 4);
					if(isDouble(d))
					{
						String e = input.substring(4,5);
						if(e.equals(">"))
						{
							return 2;
						}
						else if(e.equals(","))
						{	
							String f = input.substring(5, 6);
							if(isDouble(f))
							{
								String g = input.substring(6,7);
								if(g.equals(">"))
								{
									return 3;
								}	

							}
						}
					}
				}
			}
			
		}
		else{
			return -1;
		}
		return -1;
		
	}
	
	//function to test if a string is double
    static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
    //main
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//loop for the menu
		while(choice != 6)
		{   
			//test to see if p1 or p2 is null
			if(p1 == null)
			{
				System.out.println("Object 1 has not been assigned") ;
			}
			if(p2 == null)
			{
				System.out.println("Object 2 has not been assigned") ;
			}
			
			//print out the menu
			System.out.println("1: Change value of "+ p1);
			System.out.println("2: Change value of "+ p2);
			System.out.println("3: Add the objects.");
			System.out.println("4: Subtract the objects.");
			System.out.println("5: Find the angle between the objects.");
			System.out.println("6: Quit");
			
			System.out.println("What do you want to do ");
			
			String temp2 = scan.nextLine() ;
			//Throw Exception for the wrong menu input
			try{ choice = Integer.parseInt(temp2);}
			catch(NumberFormatException e) {
				System.out.println("Please enter an integer between 1 and 6");
				continue;
			}
					
			
			//menu option selection
				if(choice == 1)
				{
					System.out.println("Enter values in the following format: <x,y,z>");
					String value = scan.next();
					
					//checking the format; divide it into 1,2,3 format cases
					//first case
					if(FormatChecking(value)==1)
					{
						x = Double.parseDouble(value.substring(1, 2));
					}
					
					//second case
					else if(FormatChecking(value)==2)
					{
					x = Double.parseDouble(value.substring(1, 2));
					y = Double.parseDouble(value.substring(3, 4));
						
					}
					
					//last case
					else if(FormatChecking(value)==3)
					{
						x = Double.parseDouble(value.substring(1, 2));
						y = Double.parseDouble(value.substring(3, 4));
						z = Double.parseDouble(value.substring(5, 6));
					}
					else{
						System.out.println("Please input in the format as <1,2,3>. " );
						continue ;
					}
					
					//Ask user to confirm the instance of the input
					
					identity  = "string" ;
					//Case Insensitive
					while(!identity.equalsIgnoreCase("Vector") && !identity.equalsIgnoreCase("Point"))
					{
						System.out.println("Is this a Vector or a Point?");
						 identity = scan.next();
						if(identity.equalsIgnoreCase("Vector"))
						{
							System.out.println("assign a vector");
							p1 = new VectorClass(x,y,z);
						}
						else if(identity.equalsIgnoreCase("Point"))
						{
							p1= new PointClass(x,y,z);
						}
					}
					
				}
				else if(choice ==2)
				{
					System.out.println("Enter values in the following format: <x,y,z>");
					String value = scan.next();
					
					//checking the format; divide it into 1,2,3 format cases
					//first case
					if(FormatChecking(value)==1)
					{
						System.out.println("The format is correct");
						x = Double.parseDouble(value.substring(1, 2));
					}
					
					//second case
					else if(FormatChecking(value)==2)
					{
					System.out.println("The format is correct");
					x = Double.parseDouble(value.substring(1, 2));
					y = Double.parseDouble(value.substring(3, 4));
						
					}
					
					//last case
					else if(FormatChecking(value)==3)
					{
						System.out.println("The format is correct");
						x = Double.parseDouble(value.substring(1, 2));
						y = Double.parseDouble(value.substring(3, 4));
						z = Double.parseDouble(value.substring(5, 6));
					}
					else{
						System.out.println("Please input in the format as <1,2,3>. " );
						continue ;
					}
					
					
					identity  = "string" ;
					//Case Insensitive
					while(!identity.equalsIgnoreCase("Vector") && !identity.equalsIgnoreCase("Point"))
					{
						System.out.println("Is this a Vector or a Point?");
						 identity = scan.next();
						if(identity.equalsIgnoreCase("Vector"))
						{
							System.out.println("assign a vector");
							p2 = new VectorClass(x,y,z);
						}
						else if(identity.equalsIgnoreCase("Point"))
						{
							p2= new PointClass(x,y,z);
						}
					}
				}
				else if(choice ==3)
				{ 
					if(p1 instanceof PointClass && p2 instanceof PointClass)
				     {
					   System.out.println("Can not add two Points!!");
				     }
					else if(p1 instanceof PointClass && p2 instanceof VectorClass)
					{
						p1.addVector((VectorClass) p2);
					}
					else if(p1 instanceof VectorClass && p2 instanceof VectorClass)
					{
						p1.addVector((VectorClass) p2);
					}
					else if(p1 instanceof VectorClass & p2 instanceof PointClass)
					{
						p1.addPoint((PointClass) p2);
					}
					
				}
				
				//call the function contained in the corresponding class for adding
				else if(choice ==4)
				{
					if(p1 instanceof PointClass && p2 instanceof PointClass)
				     {
					   System.out.println("Can not subtract two Points!!");
				     }
					else if(p1 instanceof PointClass && p2 instanceof VectorClass)
					{
						p1.subVector((VectorClass) p2);
					}
					else if(p1 instanceof VectorClass && p2 instanceof VectorClass)
					{
						p1.subVector((VectorClass) p2);
					}
					else if(p1 instanceof VectorClass & p2 instanceof PointClass)
					{
						p1.subPoint((PointClass) p2);
					}
					
				}
				//call the function contained in the corresponding class for subtraction
				else if(choice ==5)
				{
					if(p1 instanceof PointClass && p2 instanceof PointClass)
				     {
					   p1.AnglePoint((PointClass) p2);
				     }
					else if(p1 instanceof PointClass && p2 instanceof VectorClass)
					{
						p1.AngleVector((VectorClass) p2);
					}
					else if(p1 instanceof VectorClass && p2 instanceof VectorClass)
					{
						p1.AngleVector((VectorClass) p2);
					}
					else if(p1 instanceof VectorClass & p2 instanceof PointClass)
					{
						p1.AnglePoint((PointClass) p2);
					}
				}
				
				//quit the program
				else if(choice ==6)
				{
					choice = 6;
					System.out.println("Thanks for playing with vector computation program \n");
					System.out.println("Author Elliscope Mingzhe Fang\n");
					System.out.println("Date: 2015/01/25");
				}
				
				//
				else{
				System.out.println("Please input an integer from 1 - 6 " );
				continue ;
			}
		}
		scan.close();
	}
		
}

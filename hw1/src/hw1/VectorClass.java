package hw1;

import java.text.DecimalFormat;

public class VectorClass extends ThreeDimension {
     public VectorClass(double a, double b, double c)
   {
     	super(a,b,c) ;
   }
     
     public VectorClass addPoint(PointClass a){
    	 VectorClass tempVector ;
    	 double t1 = this.x ;
    	 double t2 = this.y ;
    	 double t3 = this.z ;
    	 tempVector = new VectorClass(t1,t2,t3) ;
    	 System.out.println("The result is vector <"+ t1+","+ t2+","+t3+">") ;
    	 return tempVector ;
     }
 	public VectorClass addVector(VectorClass a){
 		 VectorClass tempVector ;
    	 double t1 = this.x + a.x ;
    	 double t2 = this.y + a.y ;
    	 double t3 = this.z + a.z ;
    	 tempVector = new VectorClass(t1,t2,t3) ;
    	 System.out.println("The result is vector <"+ t1+","+ t2+","+t3+">") ;
    	 return tempVector ;

 	}
 	public  VectorClass subPoint(PointClass a){
 		VectorClass tempVector = new VectorClass(0,0,0) ;
 		System.out.println("We can't subtract a Point from Vector") ;
 		 return tempVector ;
 	}
	public VectorClass subVector(VectorClass a){
		 VectorClass tempVector ;
    	 double t1 = this.x - a.x ;
    	 double t2 = this.y - a.y ;
    	 double t3 = this.z - a.z ;
    	 tempVector = new VectorClass(t1,t2,t3) ;
    	 System.out.println("The result is vector <"+ t1+","+ t2+","+t3+">") ;
    	 return tempVector ;
	}
	
	public double AnglePoint(PointClass a) 
	{
		 System.out.println("Can not find the angle between a point and a vector") ;
		 return -1 ;
	}
	public double AngleVector(VectorClass a) 
	{
		if(this.x + this.y +this.z != 0 && a.x + a.y + a.z != 0)
		{
			double DotProduct = this.x * a.x + this.y + a.y + this.z+ a.z;
			double length_obj1 = Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2)+Math.pow(this.z,2));
			double length_obj2 = Math.sqrt(Math.pow(a.x,2) + Math.pow(a.y,2)+Math.pow(a.z,2));
			double angle = Math.toDegrees(Math.acos(DotProduct/(length_obj1*length_obj2)));
					
			//formating the angle to 2 decimal
		    DecimalFormat f = new DecimalFormat("##.00");
			String formattedValue = f.format(angle);
			
			System.out.println("The angle between them is "+formattedValue +" degrees");
			return angle;
		} 
		else{
			System.out.println("One of the object's length is 0, thus doesn't have an angle between");
		    return -1;
		}
		
	}


 	private double round(double angle, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString(){
 		return "Vector: <"+x+","+y+","+z+">";
 	}
}

package hw1;

public class PointClass extends ThreeDimension{
	  public PointClass(double a, double b, double c)
	   {
	     	super(a,b,c) ;
	   }
	     
	     public VectorClass addPoint(PointClass a){
	    	 VectorClass tempVector ;
	    	 double t1 = this.x + a.x ;
	    	 double t2 = this.y + a.y ;
	    	 double t3 = this.z + a.z ;
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
	 	public VectorClass subPoint(PointClass a){
	 		 VectorClass tempVector = new VectorClass(0,0,0);
	    	 System.out.println("Can not subtract a point from another point") ;
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
			 System.out.println("Can not find the angle between two points") ;
			 return -1 ;
		}
		public double AngleVector(VectorClass a) 
		{
			System.out.println("Can not find the angle between a point and a vector") ;
	 		return -1;
		}

	 	public String toString(){
	 		return "Point: <"+x+","+y+","+z+">";
	 	}
}

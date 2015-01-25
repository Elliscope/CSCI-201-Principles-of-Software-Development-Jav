package hw1;

public abstract class ThreeDimension {
	double x ;
	double y ;
	double z ;
	
	public ThreeDimension(double a, double b, double c){
		x = a;
		y = b;
		z = c;
	}
	public abstract VectorClass addPoint(PointClass a);
	public abstract VectorClass addVector(VectorClass a);
	
	public abstract VectorClass subPoint(PointClass a) ;
	public abstract VectorClass subVector(VectorClass a) ;
	
	public abstract double AnglePoint(PointClass a) ;
	public abstract double AngleVector(VectorClass a) ;


}

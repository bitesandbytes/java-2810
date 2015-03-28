/*Polar Complex Class Definition
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab 
 */

@SuppressWarnings("rawtypes")
public class PolarComplex implements IComplex,Comparable
{
	double r, theta;
	
	public PolarComplex(double r, double theta)
	{
		this.r = r;
		if(theta > Math.PI)
			this.theta = theta%(2*Math.PI);
		else
			this.theta = theta;
	}
	
	//Implement the IComplex interface.
	public double Re()
	{
		return Math.cos(theta) * r;
	}
	public double Im()
	{
		return Math.sin(theta) * r;
	}
	public double Abs()
	{
		return r;
	}
	public double Arg()
	{
		return theta;
	}
	
	public IComplex conj()
	{
		return new PolarComplex(r,-theta);
	}
	public IComplex log()
	{
		double x = Math.log(r);
		double y = theta;
		double newRadius = Math.sqrt(x*x + y*y);
		double newTheta = Math.atan2(y,x);
		return new PolarComplex(newRadius,newTheta);
	}
	public IComplex exp()
	{
		double preMultiplier = Math.exp(Math.cos(theta)*r);
		return new PolarComplex(preMultiplier,r * Math.sin(theta));
	}
	public IComplex rotate(double radians)
	{
		return new PolarComplex(r,theta+radians);
	}
	public IComplex stretch(double scale)
	{
		return new PolarComplex(r*scale,theta);
	}
	
	//Implement the Comparable interface.
	public int compareTo( Object other)
	{
		double abs1 = this.Abs();
		double abs2 = ((IComplex)other).Abs();
		
		if(abs1 > abs2 )
			return 1;
		if(abs1 == abs2)
			return 0;
		return -1;
	}
}

/*Complex Class Definition
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab 
 */

@SuppressWarnings("rawtypes")
public class Complex implements IComplex,Comparable 
{
	double x, y;
	
	public Complex( double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double Re()
	{
		return x;
	}
	public double Im()
	{
		return y;
	}
	public double Abs()
	{
		return Math.sqrt(x*x + y*y);
	}
	public double Arg()
	{	
		return Math.atan2(y, x);
	}
	public IComplex conj()
	{
		Complex c = new Complex(x,-y);
		return c;
	}
	public IComplex log()
	{
		return new Complex(Math.log(Abs()),Arg());
	}
	public IComplex exp()
	{
		double preMultiplier = Math.exp(x);
		return new Complex (preMultiplier * Math.cos(y), preMultiplier * Math.sin(y));
	}
	public IComplex rotate(double radians)
	{
		double mod = Abs();
		double arg = Arg();
		return  new Complex (mod * Math.cos(arg+radians), mod*Math.sin(arg+radians));
	}
	public IComplex stretch(double scale)
	{
		return new Complex (scale*x, scale * y);
	}
	
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

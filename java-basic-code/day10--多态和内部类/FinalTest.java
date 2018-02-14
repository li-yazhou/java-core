/**/
class Single
{
	private static final  Single S = new Single();
	Single(){}

	public static Single getInstance()
	{
		s = new Single();
		return s;
	}
}

class Single2
{
	private static  Single2 s = null;
	private Single2(){}
	public static Single2 getInstance()
	{
		if(s ==null)
			s = new Single2();
		return s ;
	}
}


class Fu
{
	private Fu(){}
}
class Zi extends Fu
{

}




class FinalTest 
{
	public static void main(String[] args) 
	{
		new Zi();
	}
}

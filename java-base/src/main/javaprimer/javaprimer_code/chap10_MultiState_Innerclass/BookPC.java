
/*
笔记本电脑使用。
为了扩展笔记本的功能，但日后出现什么功能设备不知道。

定义一个规则，只要日后出现的设备都符合这个规则就可以了。
规则在java中就是接口。

*/
interface USB// 暴露的规则。
{
	public void open();
	public void close();
}


class BookPC
{
	public static void main(String[] args)
	{
		useUSB(new UPan());//功能扩展了。
		useUSB(new UsbMouse());
	}

	//使用规则。
	public static void useUSB(USB u)//接口类型的引用，用于接收(指向)接口的子类对象。//USB u= new UPan();
	{
		if(u!=null)
		{
			u.open();
			u.close();
		}
	}
}
//一年后。------------------------------
//实现规则。

//这些设备和电脑的耦合性降低了。

class UPan implements USB
{
	public void open()
	{
		System.out.println("upan open");
	}
	public void close()
	{
		System.out.println("upan close");
	}

}


class UsbMouse implements USB
{
	public void open()
	{
		System.out.println("UsbMouse open");
	}
	public void close()
	{
		System.out.println("UsbMouse close");
	}

}








/*
class Mouse
{
}

class BookPC
{
	public static void main(String[] args)
	{
		useMouse(new Mouse());
	}
	public static void useMOuse(Mouse m)
	{
		m.open();
	}
	public static void useMOuse(Mouse m)
	{
		m.open();
	}
}
*/
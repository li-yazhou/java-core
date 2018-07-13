package org.alpha.javabase.javaprimer.javaprimer_code.chap12_Chapter_Thread;

//import packa.DemoA;//������packa���е�DemoA�ࡣ
//import packa.DemoAA;
//import packa.DemoAAA;
/*
import packa.*;//������packa�������е��ࡣ
import packa.abc.*;

packa\DemoA.class 
packa\abc\DemoAbc.class

*/
//������ԭ���õ��ĸ��࣬�͵����ĸ��ࡣ

//import �����õİ���Ϊ�˼�������д��
class  PackageDemo
{
	public static void main(String[] args) 
	{

		//packa.DemoA d = new packa.DemoA();
		DemoAbc d = new DemoA();
		d.show();

		packb.DemoB b = new packb.DemoB();
		b.method();
		System.out.println("Hello Package!");
	}
}


/*

PackageDemo.java:8: �Ҳ�������
���ţ� �� DemoA
λ�ã� �� mypack.PackageDemo
                DemoA d = new DemoA();
                ^
PackageDemo.java:8: �Ҳ�������
���ţ� �� DemoA
λ�ã� �� mypack.PackageDemo
                DemoA d = new DemoA();
                              ^
2 ����

ԭ������д��

��ΪDemoA���Ѿ��а������������Ա���Ҫ��ȷ�䱨����
��ס��DemoA������ʴ�ġ� ��ȷ�����Ǳ���.����  packa.DemoA

--------------------------------------


PackageDemo.java:8: ����� packa ������
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:8: ����� packa ������
                packa.DemoA d = new packa.DemoA();
                                         ^
2 ����


ԭ�����ڵ�ǰĿ¼��û�ҵ�����Ϊpacka���������Ŀ¼�£�
Ӧ������һ��classpath��


-------------------------------------

PackageDemo.java:8: packa.DemoA �� packa �в��ǹ����ģ��޷����ⲿ������ж����
�з���
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:8: packa.DemoA �� packa �в��ǹ����ģ��޷����ⲿ������ж����
�з���
                packa.DemoA d = new packa.DemoA();
                                         ^
2 ����
--------------------------------------



PackageDemo.java:9: show() �� packa.DemoA �в��ǹ����ģ��޷����ⲿ������ж����
�з���
                d.show();
                 ^
1 ����




�ܽ᣺
�����֮�������з��ʣ������ʵİ��е��������public�ģ������ʵİ��е���ķ���Ҳ������public�ġ�




          public		protected		default		  private
ͬһ����    ok             ok              ok           ok
ͬһ����    ok             ok              ok           
������      ok             ok              
��ͬ����    ok


*/
# 动态代理与AOP


分析代理类的作用与原理及AOP概念
创建动态类及查看其方法列表信息
创建动态类的实例对象及调用其方法
完成InvocationHandler对象的内部功能
分析InvocationHandler对象的运行原理
总结分析动态代理类的设计原理与结构
编写可生成代理和插入通告的通用方法
实现类似spring的可配置的AOP框架


## 代理类的作用与原理及AOP概念

代理的概念与作用
生活中的代理，代理商。
程序中的代理
    - 要为已存在的多个具有相同接口的目标类的各个方法增加一些系统功能，例如，异常处理、日志、计算方法的运行时间、事务管理等等。
    - 编写一个与目标类具有相同接口的代理类，代理类的个每个方法调用目标类的相同方法，并在调用方法时加上系统功能的代码。

*代理
 class X
 {
    void sayHello()
	{
	  sysout("hello");
	}
 }

静态代理
 XProxy
 {
    void sayHello()
	{
	  starttime
	  X.sayHello();
	  endtime
	}
 }



编写一个与目标类具有相同接口的代理类，代理类的每个方法调用目标类的相同方法，并在调用方法时加上系统功能的代码。
     Target/Proxy（目标类和代理类）  ---->  Interface（目标类和代理类实现相同的接口）
     Client类不再直接调用 Target目标类，而是调用 Proxy代理类。

- 如果采用工厂模式和配置文件的方式进行管理，则不需要修改客户端程序，在配置文件中配置是使用目标类还是代理类，这样以后很容易切换，
  譬如，想要日志功能时就配置代理类，否则配置目标类，这样增加系统功能很容易，以后运行一段时间后，又想去掉系统功能也很容易。

  AOP――Aspect oriented program,面向方面的编程（面相切片编程）
-系统中存在交叉业务，一个交叉业务就是要切入到系统中的一个方面。
   安全，事务，日志等功能要贯穿到好多个模块中，所以它们就是交叉业务。

-用具体的程序描述交叉业务
    method1			method2				method3
    {					{					{
    -----------------------------------------------切面1（安全检查，日志记录）
    ...				...					...
    -----------------------------------------------切面2（安全检查，日志记录）
    }					}					}
   交叉业务的编程问题即为面向方面的编程AOP，AOP的目标就是要使交叉业务模块化。
   可以采用将切面代码移动到原始方法的周围，这与直接在方法中编写切面代码的运行效果是一样的。如下所示
        -----------------------------------------------切面1
        func1				func2				func3
        {					{					{
        ...				...					...
        }					}					}
        -----------------------------------------------切面2
-使用代理技术正好可以解决这种问题，代理是实现AOP功能的核心和关键技术。


只要涉及到AOP，就会有代理。
安全、事务、日志等功能要贯穿到好多个模块中，所以他们就是交叉业务。它们并不是对象。
重要原则：不要把供货商暴露给你的客户。


要为系统中的各种接口的类增加代理功能，那将需要太多的代理类，全部采用静态代理方方式，将是一件复杂的事情！

JVM可以在运行期动态生成出类的字节码，这种动态生成的类往往被用作代理类，即动态代理类。

JVM生成的动态类必须实现一个或多个接口，所以，JVM生成的动态类只能用作具有相同接口的目标类的代理。

如果目标类没有实现接口，则需要用CGLIB。

CGLIB库（开源工具库，不是JVM的标准）可以动态生成一个类的子类，一个类的子类也可以用作该类的代理，所以，如果要为一个没有实现接口的类生成动态代理类，那么可以使用CGLIB库。

代理类的各个方法中通常除了要调用目标的相应方法和对外返回目标返回的结果外，还可以在代理方法中的如下四个位置加上系统功能代码：
* 在调用目标方法之前
* 在调用目标方法之后
* 在调用目标方法前后
* 在处理目标方法异常的catch块中


---
         

## 创建动态类及查看其方法列表信息
分析JVM动态生成的类
    - 创建实现了Collection接口的动态类和查看其名称，分析Proxy.getProxyClass方法的各个参数。
    - 编码列出动态类的所有构造方法和参数签名。
    - 编码列出动态类中的所有方法和参数签名
    - 动态创建类的实例对象
        - 用反射获得构造方法
        - 编写一个最简单的InvocationHandler类
        - 调用构造方法创建动态类的实例对象，并将编写的InvocationHandler类的实例对象传进去
        - 打印创建的对象和调用对象的没有返回值的方法和getClass方法，练习调用其他有返回值的方法报告了异常
        - 将创建动态类的实例对象的代理改成匿名内部类的形式编写。
    - 总结思考：让JVM创建动态类及其实例对象，需要给它提供哪些信息？
        - 三个方面
            - 生成的类中有哪些方法，通过让其实现哪些接口的方式进行告知
            - 产生的类字节码必须有一个关联的类加载器对象
            - 生成的类中的方法的代码是怎样的，也得由我们提供。把我们的代码写在一个约定好的接口对象的方法中，把对象传给它，它调用我的方法，
              即相当于插入了我的代码。提供执行代码的对象就是那个InvocationHandler对象，它是在创建动态类的实例对象的构造方法时传递进行的。
              在上面的InvocationHandler对象的invoke方法中加一点代码，就可以看到这些代码被调用运行了。
    - 用Proxy.newInstance方法直接一步就创建出代理对象

Proxy:
	getProxyClass(ClassLoader classLoader, Interface... interfaces)//指定类加载器和目标类实现的接口


    @Test
    public void proxyClassTest(){
        Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(clazzProxy.getName());

        Constructor[] cons = clazzProxy.getConstructors();
        Method[] methods = clazzProxy.getDeclaredMethods();
        System.out.print("\n-----------------constructors-----------------");
        printMethodOrConstructor(cons);  // com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler) 只有一个构造方法

        System.out.print("\n-----------------methods-----------------");
        printMethodOrConstructor(methods);
    }

    /**
     * 打印方法的签名
     * @param executables 构造方法或者普通方法，Constructor和Method都实现了抽象类 Executable
     */
    private void printMethodOrConstructor(Executable[] executables){
        for (Executable executable : executables){
            String methodName = executable.getName();
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(methodName);
            sBuilder.append('(');
            // Class<?>[] clazz = con.getParameterTypes();
            Class[] clazzTypes = executable.getParameterTypes();  // 获取方法的参数
            for (Class type : clazzTypes)
                sBuilder.append(type.getName()).append(",");
            if (sBuilder.charAt(sBuilder.length()-1) == ',')  // 可能没有执行以上的循环
                sBuilder.deleteCharAt(sBuilder.length()-1);
            sBuilder.append(')');
            System.out.println(sBuilder);
        }
    }



## 创建动态类的实例对象及调用其方法
    动态代理类只有一个构造方法 com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler)

    /**
     * 创建代理类的实例
     * 代理类的实例方法调用的限制
     */
    private static void newInstanceByProxyTest() throws Exception {
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
        Collection coll = (Collection)constructor.newInstance(new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        System.out.println(coll); // null，但并非是空指针，而是返回值是 null 字符串
        System.out.println(coll.toString());
        //int size = coll.size();
        //调用有返回值的方法会出现异常，因为返回值是 invoke的返回结果 null，null无法转换为int或其他类型，
        //但是可以转换为 void 类型，即无返回值
        coll.clear();
    }


完成InvocationHandler对象的内部功能

    @Test
    public void getProxyByHardCode() {
        System.out.println("new proxy instance ");
        Collection collProxy = (Collection)Proxy.newProxyInstance(
                Collection.class.getClassLoader(),
                new Class[]{Collection.class},
                new InvocationHandler(){
                    // 此处是硬编码，缺乏灵活性
                    ArrayList target = new ArrayList(); // 目标对象（联想公司电脑销售部）
                    @Override
                    /**
                     * proxy: 代理对象，帮助目标对象做事情的对象（卖联想电脑的代理商）
                     * method: 代理对象要执行目标对象要完成的任务（帮A买联想电脑）
                     * args: method方法需要的参数（需要的联想电脑的性能参数）
                     *
                     * 代理最简单的实现是 return method.invoke(target, args);
                     * 但是代理在返回值之前可以做其他事情，比如说过滤 args参数，不合格不予执行等等。
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // return method.invoke(target, args);
                        System.out.println("execute.....");
                        long startTime = System.currentTimeMillis();
                        Thread.sleep(1000);
                        Object retVal = method.invoke(target,args);
                        long endTime = System.currentTimeMillis();
                        System.out.println(method.getName() + " execute time is " + (endTime - startTime));
                        return retVal;
                    }

                });
        collProxy.add("123");
        collProxy.add("abc");
        int size = collProxy.size(); //invoke的返回值
        System.out.println(size);
        System.out.println(collProxy.getClass().getName());// com.sun.proxy.$Proxy0
        //分析：查看 Proxy API文档：
        //对于从Object继承过来的方法，只有 equals,hashCode和toString三个方法委托给handler处理，其他方法自己处理，如getClass方法
    }


----53_分析InvocationHandler对象的运行原理
猜想分析动态生成的类的内部代码
-动态生成的类实现了Collection接口（可以实现若干接口），生成的类有Collection接口中的所有方法和一个如下接口InvocationHandler参数的构造方法。

-构造方法接受一个InvocationHandler对象，接受对象了要干什么呢？该方法内部的代码会是怎样的呢？
    赋值给内部引用变量，以后使用。
    $Proxy0 implements Collection
    {
        InvocationHandler handler;
        public $Proxy0(InvocationHandler handler){
            this.handler = handler;
        }
    }

-实现的Collection接口中的各个方法的代码又是怎样的呢？
 InvocationHandler接口中的定义的invoke方法接受的三个参数又是什么意思？
 client程序调用objProxy.add("aaa");方法时，涉及三要素：objProxy对象、add方法、"aaa"参数
    Class $Proxy0{
        add(Object object){
            return handler.invoke(Object proxy, Method method, Object[] args);
        }
    }

    当collProxy.size()时，会将collProxy传递给代理对象（下面的this）, "size"以字符串形式传递进去用于生成Method方法，参数是null
    // 生成的Collection接口中的方法的运行原理
    int size(){
        Method method = this.getClass().getMethod("size")
        return handler.invoke(this, method, null);
    }

    当collProxy.add("aaa")时，会将collProxy传递给代理对象，"add"以字符串形式传递进去用于生成Method方法，参数是"aaa"
    boolean add(Object obj){
        Method method = this.getClass().getMethod("add", obj.getClass);
        return handler.invoke(this, method, "aaa");
    }

-分析先前打印动态类的实例对象时，结果为什么会是null呢？
 调用有基本类型返回值的方法时为什么会出现NullPointerException异常？
    因为InvocationHandler中的invoke方法返回的类型和调用的方法返回的类型不一致导致的。
-分析为什么动态类的实例对象的getClass()方法返回了正确结果呢？
    collProxy.getClass().getName(); // $Proxy0，为什么没有转发给invoke方法呢？
    调用代理对象的从Object类继承的hashCode，equals，或者 toString这几个方法时，代理对象将调用请求转发给InvocationHandler对象，
    对于其他方法，则不转发调用请求。（Proxy文档）


----54_总结分析动态代理类的设计原理与结构
动态代理的工作原理图
    client               class $Proxy0                       InvocationHandler1                                   target
    proxy               $Proxy0(InvocationHandler)           invoke(...){..; method.invoke(target);..;}           target.method1()
    proxy.method1()     method1(){handler.invoke()}                                                               target.method2(1)
    proxy.method2(1)    method2(int a){                      InvocationHandler2
                            handler.invoke(a)                invoke(...){..; method.invoke(target);..;}
                        }


怎样将目标类传递进去？
    -直接在InvocationHandler实现类中创建目标类的实例对象，可以看运行效果和加入的日志代码，但没有实际意义。（硬编码）
    -为InvocationHandler实现类注入目标类的实例对象，不能采用匿名内部类的形式。
    -让匿名的InvocationHandler实现类访问外面方法中的目标类实例对象的final类型的引用变量。

将创建代理的过程改为一种更优雅的方式。

将系统功能代码模块化，即将切面代码也改为通过参数形式提供，怎样把执行的系统功能代码以参数形式提供？
    -把要执行的代码装到一个对象的某个方法里，然后把这个对象作为参数传递，接收者只要调用这个对象的方法，即等于执行了外界提供的代码、
    -为bind方法增加一个Advice参数。
------------------------

package neu.scse.enhance.proxy;
import java.lang.reflect.Method;

/**
 * 该接口一般有四个方法，分别是在方法之前、之后、之前之后以及异常中执行的代码
 * @author Administrator
 *
 */
public interface Advice {
	//void beforeMethod();
	//void afterMethod();
	void beforeMethod(Method method);
	void afterMethod(Method method);
}

------------------------

package neu.scse.enhance.proxy;
import java.lang.reflect.Method;

public class MyAdvice implements Advice{
	private long startTime = 0;

	@Override
	public void beforeMethod(Method method) {
		System.out.println(method.getName() + " start executing...");
		startTime = System.currentTimeMillis();
	}

	@Override
	public void afterMethod(Method method) {
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println(method.getName() + " finished...");
		System.out.println(method.getName() + " execute time is " + time);
	}
}

-动态生成的类实现了Collection接口（可以实现若干接口），生成的类有Collection接口中的所有方法和一个如下接受InvocationHandler参数的构造方法。

-构造方法接受一个InvocationHandler对象，接受对象了要干什么用呢？该方法内部的代码会是怎样的呢？
    $Proxy0 implements Collection{
		InvocationHandler handler;
		public $Proxy0(InvocationHandler handler){
			//构造方法接受参数，主要目的就是了保存起来，供本类其他成员使用
			this.handler = handler;
		}

		//生成的 Collection接口中的方法的运行原理
		int size(){
			return handler.invoke(this, this.getClass().getMethod("size"), null);
		}

		void clear(){
			handler.invoke(this,this.getClass().getMethod("clear"), null);
		}
	}
-实现的Collection接口中的各个方法的代码又是怎样的呢？ InvocationHandler接口中定义的 invoke方法接受的三个参数又是什么意思？
    Client程序调用objProxy.add("abc")方法时，涉及三要素：objProxy对象、add方法、"abc"参数
	Class Proxy${
		add(Object object){
			// proxy：代理对象，帮助目标对象做事情
			return handler.invoke(Object proxy, Method method, Object[] args);
		}
	}
把切面的程序以对象的形式进行封装，然后将对象作为参数传递，最后执行切面代码。



----55_编写可生成代理和插入通告的通用方法
    /**
     * 生成动态代理对象，（联想电脑销售代理商）
     * @param target，目标类，（联想电脑销售部）
     * @param myAdvice，其他业务对象
     * @return 返回代理对象
     */
    private static Object getProxy(final ArrayList target, final MyAdvice0 myAdvice) {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),	//target字节码的类加载器
                target.getClass().getInterfaces(),  //target实现的接口
                new InvocationHandler(){			//代理通过handler调用target的方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAdvice.beforeMethod(method);
                        Object retVal = method.invoke(target, args);
                        myAdvice.afterMethod(method);
                        return retVal;
                    }
                });
        return proxy;
    }

    ---------------------------------

    public interface Advice0 {
    	//void beforeMethod();
    	//void afterMethod();
    	void beforeMethod(Method method);
    	void afterMethod(Method method);
    }

    -------------------------------

    public class MyAdvice0 implements Advice0 {
    	private long startTime = 0;

    	@Override
    	public void beforeMethod(Method method) {
    		System.out.println(method.getName() + " start executing...");
    		startTime = System.currentTimeMillis();
    	}

    	@Override
    	public void afterMethod(Method method) {
    		long endTime = System.currentTimeMillis();
    		long time = endTime - startTime;
    		System.out.println(method.getName() + " finished...");
    		System.out.println(method.getName() + " execute time is " + time);
    	}
    }


----56_实现类似spring的可配置的AOP框架
*实现AOP功能的封装和配置
-工厂类BeanFactory负责创建目标类或代理类的实例对象，并通过配置文件实现切换。
    其getBean方法根据参数字符串返回一个相应的实例对象，
    如果参数字符串在配置文件中对应的类名不是ProxyFactoryBean，则直接返回该类的实例对象，
    否则，返回该类实例对象的getProxy方法返回的对象。

-BeanFactory的构造方法接收代表配置文件的输入流对象，配置文件格式如下：
    #xxx=java.uitl.ArrayList
    xxx=neu.scse.ProxyFactoryBean  #特殊的bean，专门创建代理的工厂
    xxx.target=java.util.ArrayList  # 目标对象
    xxx.advice=neu.scse.MyAdvice    # 通知

-ProxyFactoryBean充当封装生成动态代理的工厂，需要为工厂类提供哪些配置参数信息？
	-目标
	-通知

-编写客户端应用：
    -编写实现Advice接口的类型和在配置文件中进行配置
    -调用BeanFactory获取对象


AOP的设计思想：
// Object obj = BeanFactory.getBean("neu.scse.proxy.Student");
Object obj = BeanFactory.getBean("className");

config.properties文件中配置类的全限定名。
className = neu.scse.proxy.Student

代码
......











































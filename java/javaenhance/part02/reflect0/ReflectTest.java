
package javaenhance.part02.reflect0;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;


public class ReflectTest {

	/**
	 * 第三方的Bean操作工具 BeanUtils
	 * @throws Exception
	 */

/*	@Test
	public void test_BeanUtils() throws Exception{
		// Map map = {"a":65, "b":66};
		ReflectPoint obj = new ReflectPoint(4,6);
		// getProperty方法返回值是String类型的
		String retval = BeanUtils.getProperty(obj, "x");
		System.out.println(retval);
		String value = "12";
		// setProperty方法设置属性的值是String类型
		BeanUtils.setProperty(obj, "x", value);
		System.out.println(obj.getX());
		
		System.out.println("---------------");
		int intRetVal = (int)PropertyUtils.getProperty(obj, "x");
		System.out.println(intRetVal);
		PropertyUtils.setProperty(obj, "x", 100);
		System.out.println(obj.getX());
		System.out.println("---------------");
		
		BeanUtils.setProperty(obj, "birthday.time", "1000");
		String result = BeanUtils.getProperty(obj, "birthday.time");
		System.out.println(result);
	}*/
	
	
	@Test
	public void test_Introspector() throws Exception{
		ReflectPoint obj = new ReflectPoint(2,5);
		String propertyName = "x";
		Object retval = getProperty(obj, propertyName);
		System.out.println(retval);
		
		Object newValue = 12;
		setProperty(obj, propertyName, newValue);
		System.out.println(getProperty(obj,"x"));
		
	}


	private void setProperty(ReflectPoint obj, String propertyName, Object newValue)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
		Method methodSetX = pd.getWriteMethod();
		methodSetX.invoke(obj, newValue);
	}


	private Object getProperty(Object obj, String propertyName)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
		Method methodGetX = pd.getReadMethod();
		return methodGetX.invoke(obj);
	}
	
	
	@Test
	public void test_ClassLoader() throws Exception{
		//InputStream ips = new FileInputStream(new File("config.properties"));
		//InputStream ips = ReflectTest.class.getClassLoader().getResourceAsStream("neu/scse/enhance/reflect/config.properties");
		InputStream ips = ReflectTest.class.getResourceAsStream("resources/config.properties");
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		String className = props.getProperty("className");
		System.out.println(className);
	}
}


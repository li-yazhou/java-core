package org.alpha.javabase.javaenhance.part02.annotation0;

import java.util.Arrays;

@MyAnnotation(ID="0001", name="Jeff", annotationAttr=@MetaAnnotation("Jeff"))
public class AnnotationTest {
	
	@MyAnnotation(gender="male", ID = "0002", name = "Lee")
	public static void main(String[] args) throws Exception{
		System.out.println("test Annotation");
		if(AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)){
			//MyAnnotation myAnno = MyAnnotation.class.newInstance();
			MyAnnotation myAnno = AnnotationTest.class.getAnnotation(MyAnnotation.class);
			System.out.println("ID="+ myAnno.ID() +", name="+ myAnno.name() +", gender="+ myAnno.gender()+".");
			System.out.println("Arr=" + Arrays.toString(myAnno.arr()));
			System.out.println("valueOfAnnotatonAttr=" + myAnno.annotationAttr().value());
			
		}
	}
	
	
}

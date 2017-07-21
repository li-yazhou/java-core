package book.jvm.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-02 21:23
 */
public class HeapOOM {
    static class OOMObject{
        Integer[] array = new Integer[10000];
    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}

/*
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at org.java.book.jvm.ch02.HeapOOM$OOMObject.<init>(HeapOOM.java:14)
	at org.java.book.jvm.ch02.HeapOOM.main(HeapOOM.java:20)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
 */

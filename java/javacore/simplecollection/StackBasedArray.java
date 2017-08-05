package javacore.simplecollection;

import java.util.Iterator;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-27 15:35
 */
public class StackBasedArray<T> implements Iterable<T>{
    private int initcapacity = 16;
    private int len = 0;
    private T[] stack = null;

    public StackBasedArray(){
        initStack();
    }

    public StackBasedArray(int initcapacity){
        this.initcapacity = initcapacity;
        initStack();
    }

    private void initStack(){
        this.stack = (T[]) new Object[initcapacity];
    }

    private void resize(int newcapacity){

    }


    public void push(T t){
        if (len == stack.length) resize(stack.length * 2);
        stack[len ++] = t;
    }

    public T pop(){
        if (len <= 0) return null;
        T t = stack[--len];
        if (len > 0 && len == stack.length/4) resize(stack.length/2);
        return t;
    }

    public T peek(){
        if (len <= 0) return null;
        return stack[len-1];
    }

    public void clear(){
        this.len = 0;
        // resize(16);
    }

    public int size(){
        return this.len;
    }

    public int capacity(){
        return stack.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    @Override
    public String toString(){
        if (len <= 0) return null;

        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < len; i ++)
            string.append(stack[i]).append(", ");
        string.deleteCharAt(string.length()-1);
        string.deleteCharAt(string.length()-1);
        string.append("]");
        // return Arrays.toString(stack);
        return string.toString();
    }


    public static void main(String... args){
        StackBasedArray<Integer> stack = new StackBasedArray<>(20);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println(stack);


        System.out.println("size = " + stack.size());
        System.out.println("capacity = " + stack.capacity());


        System.out.println("peek = " + stack.peek());
        int top = stack.pop();
        System.out.println("top = " + top);

        System.out.println("peek = " + stack.peek());
        top = stack.pop();
        System.out.println("top = " + top);

        System.out.println("peek = " + stack.peek());
        top = stack.pop();
        System.out.println("top = " + top);

    }
}

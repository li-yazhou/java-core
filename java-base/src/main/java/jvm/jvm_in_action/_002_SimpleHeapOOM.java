package jvm.jvm_in_action;

import java.util.ArrayList;

/**
 * @author liyazhou1
 * @date 2020/4/13
 */
public class _002_SimpleHeapOOM {

    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        int _1MB = 1024 * 1024;
        for (int i = 0; i < 1024; i ++) {
            list.add(new byte[_1MB]);
        }
        System.out.println("finished.");
    }
}

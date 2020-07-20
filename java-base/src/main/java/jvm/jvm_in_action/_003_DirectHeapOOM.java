package jvm.jvm_in_action;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyazhou1
 * @date 2020/4/13
 */
public class _003_DirectHeapOOM {

    public static void main(String[] args) {

        List<ByteBuffer> list = new ArrayList<>();
        int _1M = 1024 * 1024;
        for (int i = 0; i < 2048; i ++) {
            ByteBuffer bb = ByteBuffer.allocateDirect(_1M);
//            list.add(bb);
            System.out.println("i = " + i);
//            System.gc();
        }
    }
}

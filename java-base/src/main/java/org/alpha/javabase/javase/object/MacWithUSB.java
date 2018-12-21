package org.alpha.javabase.javase.object;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/14
 */


/*
    笔记本电脑使用。

    为了扩展笔记本的功能，但日后出现什么功能设备不知道。

    定义一个规则，只要日后出现的设备都符合这个规则就可以了。
    规则在java中就是接口。
 */

public class MacWithUSB {

    public void useUSB(USB device) {
        if (device != null) {
            device.open();
            device.close();
        }
    }


    public static void main(String[] args) {
        MacWithUSB mac = new MacWithUSB();
        mac.useUSB(new USBDisk());
        mac.useUSB(new USBMouse());
    }

}


/*
    规则
 */
interface USB {
    void close();
    void open();
}


class USBMouse implements USB {

    @Override
    public void close() {
        System.out.println("close mouse.");
    }

    @Override
    public void open() {
        System.out.println("open mouse.");
    }
}


class USBDisk implements USB {

    @Override
    public void close() {
        System.out.println("close USB Disk");
    }

    @Override
    public void open() {
        System.out.println("close USB Disk");
    }
}



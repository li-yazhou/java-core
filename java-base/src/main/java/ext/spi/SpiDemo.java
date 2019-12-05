package ext.spi;

import ext.spi.serviceloader.Command;

import java.util.ServiceLoader;

/**
 * Service Provider Interface
 *
 * @author liyazhou1
 * @date 2019/12/5
 */
public class SpiDemo {

    public static void main(String[] args) {

        ServiceLoader<Command> serviceLoader = ServiceLoader.load(Command.class);


        System.out.println("serviceLoader = " + serviceLoader);

        for (Command cmd : serviceLoader) {
            System.out.println("cmd = " + cmd);
            cmd.execute();
            System.out.println();
        }
    }
}

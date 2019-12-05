package ext.spi.serviceloader.impl;

import ext.spi.serviceloader.Command;

/**
 * @author liyazhou1
 * @date 2019/12/5
 */
public class ShutdownCommand implements Command {
    @Override
    public void execute() {
        System.out.println("shutdown server");
    }
}

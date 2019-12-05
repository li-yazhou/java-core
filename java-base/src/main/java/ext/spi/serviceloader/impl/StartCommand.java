package ext.spi.serviceloader.impl;

import ext.spi.serviceloader.Command;

/**
 * @author liyazhou1
 * @date 2019/12/5
 */
public class StartCommand implements Command {

    @Override
    public void execute() {
        System.out.println("start server");
    }
}

package javase.nio.demo;

import java.io.IOException;
import java.nio.file.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 17:04
 */
public class WatchServiceTest {
    public static void main(String... args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get("c:").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        while (true){
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()){
                System.out.println(event.context() + " 文件发生了 " + event.kind() + " 事件！");
            }

            boolean valid = key.reset();
            if (!valid){
                break;
            }

        }

    }
}

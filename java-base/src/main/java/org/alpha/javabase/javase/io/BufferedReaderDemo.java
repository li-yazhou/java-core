package org.alpha.javabase.javase.io;

import java.io.*;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/17
 */
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {

        BufferedReader buffr = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

        for (String line; (line = buffr.readLine())!= null; ) {
            if ("END".equalsIgnoreCase(line)) {
                break;
            }
            buffw.write(line);
            buffw.newLine();
            buffw.flush();
        }
    }
}

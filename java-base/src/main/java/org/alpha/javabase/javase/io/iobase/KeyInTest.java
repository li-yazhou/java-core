package org.alpha.javabase.javase.io.iobase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 14:38
 */
public class KeyInTest {
   /* @Test
    public void inputStreamReaderTest(){
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    System.out.println("repeat :: " + line);
                    if ("exit".equals(line)){
                        System.exit(1);
                    }
                }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    */


    public static void main(String[] args){
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println("repeat :: " + line);
                if ("exit".equals(line)){
                    System.exit(1);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}

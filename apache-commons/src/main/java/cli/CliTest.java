package cli;

import org.apache.commons.cli.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Properties;

/**
 * <p>Description: <p/>
 *
 * @author : liyazhou1
 * @date : 2018/7/10
 */
public class CliTest {
    /*
        Apache Commons CLI 开发命令工具
            https://commons.apache.org/proper/commons-cli/usage.html
            https://www.ibm.com/developerworks/cn/java/j-lo-commonscli/index.html


        命令行处理分为三个步骤：定义，解析和询问阶段。
            CLI定义阶段
                CLI定义阶段的目标结果就是创建Options实例。

            CLI解析阶段
                CLI解析阶段的目标结果就是创建CommandLine实例。

            CLI询问阶段
                CLI询问阶段的目标结果就是将所有通过命令行以及处理参数过程中得到的文本信息传递给用户的代码。
     */

    /*
        创建不需要参数的Option
            program arguments
                -t
     */
    public static void main(String[] args) throws ParseException {

        Options options = new Options();

        options.addOption("t", false, "display current time");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("t")) {
            // print current time
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println("localDateTime = " + localDateTime);
        }
    }


    /*
        创建需要参数的Option
            program arguments
                -t China
     */
    @Test
    public void test() throws ParseException {
        String[] args = {"-t", "China"};

        Options options = new Options();
        options.addOption("t", true, "country code");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("t")) {
            String country = cmd.getOptionValue("t");
            System.out.println("country = " + country);
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println("localDateTime = " + localDateTime);
        }
    }


    /*
        Boolean Option
     */
    @Test
    public void booleanOption() throws ParseException {

        String[] args = {
                "-help",
                "-key", "key-value",
        };

        /* without arg */
        Option help = new Option("help", "help message");
        /* with arg */
        Option key = new Option("key", true, "key arg");

        Options options = new Options();
        options.addOption(help);
        options.addOption(key);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("help")) {
            System.out.println("help manual");
        }

        if (cmd.hasOption("key")) {
            String value = cmd.getOptionValue("key");
            System.out.println("value = " + value);
        }
    }


    /*
        Argument Option
     */
    @Test public void argOption() {
        String[] args = {};

    }


    /*
        Java Property Option
     */
    @Test
    public void javaPropertyOption() throws ParseException {

        String[] args = {
                "-Dkey=value",
                "-Nname=value"
        };

        Option property = OptionBuilder.withArgName("property=value")
                .hasArgs(2)
                .withValueSeparator('=')
                .withDescription("use value for given property")
                .create("D");

        Option nvProperty = OptionBuilder.withArgName("property=value")
                .hasArgs(2)
                .withValueSeparator('=')
                .withDescription("name, value")
                .create("N");

        Options options = new Options();
        options.addOption(property);
        options.addOption(nvProperty);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("D")) {
            Properties properties = cmd.getOptionProperties("D");
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement().toString();
                String val = properties.get(key).toString();
                System.out.println("key = " + key);
                System.out.println("val = " + val);

            }
        }

        if (cmd.hasOption('N')) {
            Properties properties = cmd.getOptionProperties("N");
            Enumeration enumeration = properties.propertyNames();
            if (enumeration.hasMoreElements()) {
                String k = enumeration.nextElement().toString();
                String v = properties.get(k).toString();
                System.out.println("k = " + k);
                System.out.println("v = " + v);
            }
        }
    }

}

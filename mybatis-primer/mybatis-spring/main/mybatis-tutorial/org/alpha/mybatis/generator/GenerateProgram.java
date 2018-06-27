package org.alpha.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/13 21:56
 */
public class GenerateProgram {

    public static void main(String... args) throws IOException,
            XMLParserException, InvalidConfigurationException,
            SQLException, InterruptedException {
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);

        // 指定逆向工程配置文件
        File configFile = new File("mybatis-config/generator-config-simple.xml");
        Configuration config = cp.parseConfiguration(configFile);

        boolean override = true;
        DefaultShellCallback callback = new DefaultShellCallback(override);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

}

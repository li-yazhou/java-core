package springbasic.spring_in_action4.ch02_bean.case01_autowired.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-06 15:44
 */

@Configuration
// 指定扫描组件的范围
// @ComponentScan  // @ComponentScan，默认会扫描与配置类相同的包以及子包，查找带有@Component的类

// @ComponentScan("spring.spring_in_action4.ch02_bean.case01.soundsystem")
// @ComponentScan(value="spring.spring_in_action4.ch02_bean.case01.soundsystem")，与上面的配置等价

// @ComponentScan(basePackages = "spring.spring_in_action4.ch02_bean.case01.soundsystem")
 @ComponentScan(basePackages = {"springbasic.spring_in_action4.ch02_bean.case01_autowired.soundsystem"})

//@ComponentScan(basePackageClasses = SgtPeppers.class)
//@ComponentScan(basePackageClasses = {SgtPeppers.class})
public class CDPlayerConfig {

}

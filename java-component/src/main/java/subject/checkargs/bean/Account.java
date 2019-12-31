package subject.checkargs.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
/**
 * @author liyazhou1
 * @date 2019/12/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    @NotNull
    @Length(max = 20)
    private String userName;
    @NotNull
    @Pattern(regexp = "[A-Z][a-z][0-9]")
    private String passWord;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date createTime;
    private String alias;
    @Max(10)
    @Min(1)
    private Integer level;
    private Integer vip;
}

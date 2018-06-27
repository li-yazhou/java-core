package org.alpha.mybatis.generator.mapper;

import java.util.List;
import org.alpha.mybatis.generator.po.Orderdetail;
import org.alpha.mybatis.generator.po.OrderdetailExample;
import org.apache.ibatis.annotations.Param;

public interface OrderdetailMapper {
    long countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);
}
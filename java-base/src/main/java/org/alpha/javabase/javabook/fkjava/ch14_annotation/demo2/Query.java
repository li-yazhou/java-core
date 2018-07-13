package org.alpha.javabase.javabook.fkjava.ch14_annotation.demo2;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-19 14:07
 */
public interface Query {
    void query();  // 严格查询，相等查询
    void likeQuery();  // 模糊查询，like查询
}

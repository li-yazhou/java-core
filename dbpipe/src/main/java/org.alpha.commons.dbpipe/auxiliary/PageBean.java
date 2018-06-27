package org.alpha.commons.dbpipe.auxiliary;

import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:37
 */
public class PageBean<E> {
    private int pageSize;  // 分页大小
    private int currPageIndex;  // 当前分页页码
    private int pageTotal;  // 分页总数
    private int count;  // 总记录数目
    private List<E> eList = null;   // 分页内的对象集合

    public PageBean(int pageSize, int currPageIndex) {
        this.pageSize = pageSize;
        this.currPageIndex = currPageIndex;
    }

    public PageBean(int pageSize, int currPageIndex, int pageTotal, int count, List<E> eList) {
        this.pageSize = pageSize;
        this.currPageIndex = currPageIndex;
        this.pageTotal = pageTotal;
        this.count = count;
        this.eList = eList;
    }

    public PageBean(){}

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPageIndex() {
        return currPageIndex;
    }

    public void setCurrPageIndex(int currPageIndex) {
        this.currPageIndex = currPageIndex;
    }

    public int getTotalPageNuber() {
        return pageTotal;
    }

    public void setTotalPageNuber(int totalPageNuber) {
        this.pageTotal = totalPageNuber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<E> geteList() {
        return eList;
    }

    public void seteList(List<E> eList) {
        this.eList = eList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageSize=" + pageSize +
                ", currPageIndex=" + currPageIndex +
                ", totalPageNuber=" + pageTotal +
                ", count=" + count +
                ", eList=" + eList +
                '}';
    }
}

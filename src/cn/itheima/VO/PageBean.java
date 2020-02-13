package cn.itheima.VO;

import java.util.List;

public class PageBean {
    //当前页
    private Integer currentPage;
    //每页条数
    private Integer pageSize;
    //总页数
    private Integer totalPage;
    //总记录数
    private Integer totalCount;
    //数据集合
    private List list;

    public PageBean(Integer currentPage,Integer pageSize,Integer totalCount){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        //如果当前页没有指定，则显示第一页
        if(this.currentPage == null){
            this.currentPage = 1;
        }
        //如果每页显示条数没有指定，则每页显示三条
        if (this.pageSize == null){
            this.pageSize = 3;
        }

        //计算总页数
        this.totalPage = (this.totalCount + this.pageSize - 1)/this.pageSize;
        //判断页数是否超出范围
        if(this.currentPage < 1){
            this.currentPage = 1;
        }
        if(this.currentPage > this.totalPage){
            this.currentPage = this.totalPage;
        }
    }
    //计算起始索引
    public int getStart(){
        return (this.currentPage-1)*this.pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer gettotalPage() {
        return totalPage;
    }

    public void settotalPage(Integer tatalPage) {
        this.totalPage = tatalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}

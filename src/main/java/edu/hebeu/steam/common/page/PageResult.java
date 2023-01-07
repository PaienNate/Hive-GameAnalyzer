package edu.hebeu.steam.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 分页数据
     */
    private List<?> content;

    public PageResult(IPage page) {
        this.setPageNum((int) page.getCurrent());
        this.setPageSize((int) page.getSize());
        this.setTotalSize(page.getTotal());
        this.setTotalPages((int) page.getPages());
        this.setContent(page.getRecords());
    }
}

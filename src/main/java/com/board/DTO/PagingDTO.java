package com.board.DTO;

public class PagingDTO {
    private Integer displayRowCount = 5;
    private Integer rowStart, rowEnd;
    private Integer totalPages, totalCount, pageCurrent=1, pageStart, pageEnd;

    public Integer getDisplayRowCount() {
        return displayRowCount;
    }

    public void setDisplayRowCount(Integer displayRowCount) {
        this.displayRowCount = displayRowCount;
    }

    public Integer getRowStart() {
        return rowStart;
    }

    public void setRowStart(Integer rowStart) {
        this.rowStart = rowStart;
    }

    public Integer getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(Integer rowEnd) {
        this.rowEnd = rowEnd;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }

    public void pageCalculate(Integer total) {
        totalCount = total;
        totalPages = (int)(total/displayRowCount);

        if(total % displayRowCount > 0)
            totalPages++;

        pageStart = (pageCurrent - (pageCurrent-1) % displayRowCount);
        pageEnd = (pageStart) + (displayRowCount-1);

        if(pageEnd > totalPages)
            pageEnd = totalPages;

        rowStart = ((pageCurrent-1) * displayRowCount) + 1;
        rowEnd = rowStart + (displayRowCount-1);
    }
}
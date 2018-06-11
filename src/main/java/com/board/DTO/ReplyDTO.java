package com.board.DTO;

public class ReplyDTO {
    private int brd_idx, reno;
    private String rewriter, redeleteflag, rememo, redate;

    public int getBrd_idx() {
        return brd_idx;
    }

    public void setBrd_idx(int brd_idx) {
        this.brd_idx = brd_idx;
    }

    public int getReno() {
        return reno;
    }

    public void setReno(int reno) {
        this.reno = reno;
    }

    public String getRewriter() {
        return rewriter;
    }

    public void setRewriter(String rewriter) {
        this.rewriter = rewriter;
    }

    public String getRedeleteflag() {
        return redeleteflag;
    }

    public void setRedeleteflag(String redeleteflag) {
        this.redeleteflag = redeleteflag;
    }

    public String getRememo() {
        return rememo;
    }

    public void setRememo(String rememo) {
        this.rememo = rememo;
    }

    public String getRedate() {
        return redate;
    }

    public void setRedate(String redate) {
        this.redate = redate;
    }


}

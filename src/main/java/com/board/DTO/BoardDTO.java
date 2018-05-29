package com.board.DTO;

public class BoardDTO {
    private int brdno, brdhit;
    private String brdtitle, brdwriter, brdmemo, brddate, brddeleteflag;

    public int getBrdhit() {
        return brdhit;
    }

    public void setBrdhit(int brdhit) {
        this.brdhit = brdhit;
    }

    public String getBrddeleteflag() {
        return brddeleteflag;
    }

    public void setBrddeleteflag(String brddeleteflag) {
        this.brddeleteflag = brddeleteflag;
    }

    public int getBrdno() {
        return brdno;
    }

    public void setBrdno(int brdno) {
        this.brdno = brdno;
    }

    public String getBrdtitle() {
        return brdtitle;
    }

    public void setBrdtitle(String brdtitle) {
        this.brdtitle = brdtitle;
    }

    public String getBrdwriter() {
        return brdwriter;
    }

    public void setBrdwriter(String brdwriter) {
        this.brdwriter = brdwriter;
    }

    public String getBrdmemo() {
        return brdmemo;
    }

    public void setBrdmemo(String brdmemo) {
        this.brdmemo = brdmemo;
    }

    public String getBrddate() {
        return brddate;
    }

    public void setBrddate(String brddate) {
        this.brddate = brddate;
    }
}

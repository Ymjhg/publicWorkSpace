package com.manji.pojo;

import java.util.Date;

/**
 * Created by 杨港 on 2019/9/26.
 */
public class Notes {
    private String wordid;
    private String userid;
    private String word;
    private String notes;
    private Date createDate;
    private Date updateDate;
    private int isdelete=0;

    public String getWordid() {
        return wordid;
    }

    public void setWordid(String wordid) {
        this.wordid = wordid;
    }

    public String  getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}

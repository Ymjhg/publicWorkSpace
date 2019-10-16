package com.manji.service.resultBean;

import com.manji.pojo.Notes;

/**
 * Created by 杨港 on 2019/9/28.
 */
public class SearchNotesBean {
    public Notes notes;
    public String resultInfo;

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
}

package com.manji.service.inter;

import com.manji.pojo.Notes;
import com.manji.service.resultBean.AddNotesBean;
import com.manji.service.resultBean.DeleteNotesBean;
import com.manji.service.resultBean.SearchNotesBean;

import java.util.List;

/**
 * Created by 杨港 on 2019/9/26.
 */
public interface LexiconService {

    public AddNotesBean addNotes(Notes notes);

    public SearchNotesBean searchNotes(String searchWord,String userid);

    public long queryNotesTotalPage(String userid);

    public List<Notes> queryAllNotes(String pageNow,String userid);

    public DeleteNotesBean deleteNotes(String wordid);

    public AddNotesBean updateNotes(String wordid,String wordNew,String notesNew);

}

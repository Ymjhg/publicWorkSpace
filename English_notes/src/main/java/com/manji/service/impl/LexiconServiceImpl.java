package com.manji.service.impl;

import com.manji.ConstantDatas;
import com.manji.dao.LexiconDao;
import com.manji.pojo.Notes;
import com.manji.service.inter.LexiconService;
import com.manji.service.resultBean.AddNotesBean;
import com.manji.service.resultBean.DeleteNotesBean;
import com.manji.service.resultBean.SearchNotesBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 杨港 on 2019/9/26.
 */
@Service
public class LexiconServiceImpl implements LexiconService {

    @Resource
    private LexiconDao lexiconDao;

    //添加笔记
    public AddNotesBean addNotes(Notes notes) {
        AddNotesBean addNotesBean = new AddNotesBean();
        try {
            Notes note = lexiconDao.queryNotesByWord(notes.getWord(),notes.getUserid());
            if (note !=null) {
                addNotesBean.setSucess(false);
                addNotesBean.setResultInfo("添加失败，该单词已存在！");
                return addNotesBean;
            }
            boolean isSucess = lexiconDao.insertNotes(notes);
            addNotesBean.setSucess(isSucess);
            if (isSucess) {
                addNotesBean.setResultInfo("添加成功");
            } else {
                addNotesBean.setResultInfo("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            addNotesBean.setSucess(false);
            addNotesBean.setResultInfo("服务器异常，请重试！");
        }
        return addNotesBean;
    }

    //查询笔记
    public SearchNotesBean searchNotes(String searchWord,String userid) {
        SearchNotesBean searchNotesBean=new SearchNotesBean();
        try {
            Notes notes = lexiconDao.queryNotesByWord(searchWord,userid);
            if (notes==null) {
                searchNotesBean.setResultInfo("查询失败，该单词不存在");
            }else {
                searchNotesBean.setNotes(notes);
                searchNotesBean.setResultInfo("查询成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            searchNotesBean.setResultInfo("服务器异常请重试！！");
        }
        return searchNotesBean;
    }

    //分页查询总页数
    public long queryNotesTotalPage(String userid) {
        long count = lexiconDao.queryNotesCount(userid);
        long totalPage = (long) Math.ceil(count * 1.0 / ConstantDatas.NOTES_COUNT);
        return totalPage;
    }

    //分页查询全部笔记
    public List<Notes> queryAllNotes(String pageNow, String userid) {
        int startPos=(Integer.parseInt(pageNow)-1)*ConstantDatas.NOTES_COUNT;
        List<Notes> notes = lexiconDao.queryAllNotes(userid, startPos, ConstantDatas.NOTES_COUNT);
        return notes;
    }

    //删除笔记
    public DeleteNotesBean deleteNotes(String wordid) {
        DeleteNotesBean deleteNotesBean=new DeleteNotesBean();
        try {
            boolean isSucess = lexiconDao.deleteNotes(wordid);
            deleteNotesBean.setSucess(isSucess);
            if (isSucess) {
                deleteNotesBean.setResultInfo("删除成功");
            }else{
                deleteNotesBean.setResultInfo("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            deleteNotesBean.setSucess(false);
            deleteNotesBean.setResultInfo("服务器错误，请重试");
        }
        return deleteNotesBean;
    }

    //修改笔记
    public AddNotesBean updateNotes(String wordid, String wordNew, String notesNew) {
        AddNotesBean updateNotesBean=new AddNotesBean();
        try {
            boolean isSucess = lexiconDao.updateNotes(wordid, wordNew, notesNew,new Date());
            updateNotesBean.setSucess(isSucess);
            if (isSucess) {
                updateNotesBean.setResultInfo("修改成功");
            }else{
                updateNotesBean.setResultInfo("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            updateNotesBean.setSucess(false);
            updateNotesBean.setResultInfo("服务器错误，请重试");
        }
        return updateNotesBean;
    }
}

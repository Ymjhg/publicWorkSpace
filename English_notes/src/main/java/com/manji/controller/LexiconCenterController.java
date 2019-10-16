package com.manji.controller;

import com.alibaba.fastjson.JSON;
import com.manji.ConstantDatas;
import com.manji.pojo.Notes;
import com.manji.pojo.User;
import com.manji.service.inter.LexiconService;
import com.manji.service.resultBean.AddNotesBean;
import com.manji.service.resultBean.DeleteNotesBean;
import com.manji.service.resultBean.SearchNotesBean;
import com.manji.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by 杨港 on 2019/9/25.
 */
@Controller
public class LexiconCenterController {

    @Resource
    private LexiconService lexiconService;

    @RequestMapping("/shortcut/{path}")
    public String goToItemList(@PathVariable(name = "path") String path,HttpSession session) {
        return path;
    }

    @RequestMapping("/safe/addNotes")
    public String addNotes(Notes notes, Model model, HttpSession session) {
        User userNow = (User) session.getAttribute(ConstantDatas.USER_NOW);
        notes.setUserid(userNow.getUserid());
        notes.setWordid(UUIDUtils.getUUid());
        notes.setCreateDate(new Date());
        notes.setUpdateDate(new Date());
        AddNotesBean addNotesBean = lexiconService.addNotes(notes);
        model.addAttribute(ConstantDatas.ADD_NOTES_MSG, addNotesBean.getResultInfo());
        return "AddNotes";
    }

    @RequestMapping("/safe/searchNotes")
    public String searchNotes(String searchWord, Model model,HttpSession session) {
        User userNow = (User) session.getAttribute(ConstantDatas.USER_NOW);
        SearchNotesBean searchNotesBean = lexiconService.searchNotes(searchWord,userNow.getUserid());
        Notes notes = searchNotesBean.getNotes();
        if (notes != null) {
            model.addAttribute(ConstantDatas.SEARCH_WORD, notes.getWord());
            model.addAttribute(ConstantDatas.SEARCH_NOTES, notes.getNotes());
        }
        model.addAttribute(ConstantDatas.SEARCH_NOTES_MSG, searchNotesBean.getResultInfo());
        return "SearchNotes";
    }

    @RequestMapping("/safe/queryAllNotes")
    public String queryAllNotes(String pageNow, Model model, HttpSession session) {
        if (pageNow == null || "".equals(pageNow)) {
            pageNow = "1";
        }
        User userNow = (User) session.getAttribute(ConstantDatas.USER_NOW);
        long totalPage = lexiconService.queryNotesTotalPage(userNow.getUserid());
        if (totalPage!=0 && Integer.parseInt(pageNow)>totalPage) {
            pageNow=String.valueOf(Integer.parseInt(pageNow)-1);
        }
        List<Notes> notes = lexiconService.queryAllNotes(pageNow, userNow.getUserid());
        model.addAttribute("notes", notes);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageNow", pageNow);
        return "LookAllNotes";
    }

    @RequestMapping("/safe/deleteNotes")
    public String deleteNotes(String wordid,String pageNow,Model model,HttpSession session){
        DeleteNotesBean deleteNotesBean = lexiconService.deleteNotes(wordid);
        model.addAttribute(ConstantDatas.RESULT_INFO,deleteNotesBean.getResultInfo());
        queryAllNotes(pageNow,model,session);
        return "LookAllNotes";
    }

    @RequestMapping("/safe/updateNotes")
    public  void  updateNotes(String wordid, String wordNew, String notesNew, HttpServletResponse response) throws IOException {
        AddNotesBean updateNotesBean = lexiconService.updateNotes(wordid, wordNew, notesNew);
        String jsonBean = JSON.toJSONString(updateNotesBean);
//        System.out.println("jsonBean = " + jsonBean);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonBean);
    }
}

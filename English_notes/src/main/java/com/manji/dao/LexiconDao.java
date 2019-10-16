package com.manji.dao;

import com.manji.pojo.Notes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by 杨港 on 2019/9/26.
 */
@Repository
public interface LexiconDao {

    @Insert("insert into lexicon values(#{wordid},#{userid},#{word},#{notes},#{createDate},#{updateDate},#{isdelete})")
    public boolean insertNotes(Notes notes);

    @Select("select * from lexicon where word=#{word} and userid=#{userid}")
    public Notes queryNotesByWord(@Param("word") String word,@Param("userid") String userid);

    @Select("select count(*) from lexicon where userid=#{userid}")
    public long queryNotesCount(String userid);

    @Select("select * from lexicon where userid=#{userid} limit ${startPos},${count}")
    public List<Notes> queryAllNotes(@Param("userid") String userid,@Param("startPos") int startPos,@Param("count") int count);

    @Delete("delete from lexicon where wordid=#{wordid}")
    public boolean deleteNotes(String wordid);

    @Update("update lexicon set notes=#{notesNew}, word=#{wordNew},updateDate=#{updateDate} where wordid=#{wordid}")
    public boolean updateNotes(@Param("wordid") String wordid, @Param("wordNew") String wordNew, @Param("notesNew") String notesNew,@Param("updateDate")Date updateDate);
}

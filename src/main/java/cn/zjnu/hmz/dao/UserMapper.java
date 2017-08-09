package cn.zjnu.hmz.dao;

import cn.zjnu.hmz.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectNick(String nickName);

    int insertUser(@Param("hxid") String hxid, @Param("nickName") String nickName, @Param("photo") String photo, @Param("sex") Integer sex1, @Param("pass") String pass);

    int insertNorUser(@Param("hxid") String hxid, @Param("pass") String pass,@Param("nickName") String nickName, @Param("photo") String photo, @Param("sex") Integer sex);

    User getOneInfo(String hxid);

    int updateNick(@Param("nickname")String nickname,@Param("hxid")String hxid);

    int updateSig(@Param("Sig")String Sig,@Param("hxid")String hxid);

    int updateSex(@Param("sex")Integer sex,@Param("hxid") String hxid);

    int updatePic(@Param("url")String url,@Param("hxid") String hxid);

    User getPic(@Param("hxid") String hxid);

}
package cn.zjnu.hmz.service;


import cn.zjnu.hmz.Vo.UserVo;
import cn.zjnu.hmz.model.User;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/8/7.
 */
public interface UserService {

    UserVo insertUser(String nickName, String photo, String sex);

    int insertNorUser(String hxid, String pass,String nickName,String photo,String sex);

    User getInfo(String hxid);

    int updateNick(String nickName,String hxid);


    int updateSig(String Sig,String hxid);

    int updateSex(Integer sex,String hxid);

    int updatePic(String url,String hxid);

    User getPic(String hxid);

}

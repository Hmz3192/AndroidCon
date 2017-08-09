package cn.zjnu.hmz.service.impl;

import cn.zjnu.hmz.Vo.UserVo;
import cn.zjnu.hmz.dao.UserMapper;
import cn.zjnu.hmz.model.User;
import cn.zjnu.hmz.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/8/7.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;
    @Override
    public UserVo insertUser(String nickName, String photo, String sex) {
        double v = Math.random() * 9000 + 1000;
        UserVo userVo = new UserVo();
        List<User> users = userMapper.selectNick(nickName);
        if (users.size() == 1) {
            userVo.setUser(users.get(0));
            userVo.setTime("1");
            return userVo;
//                    已经注册，直接返回hxid
        } else if (users.size() == 0) {
            String str = String.valueOf(v);//浮点变量a转换为字符串str
            int idx = str.lastIndexOf(".");//查找小数点的位置
            String strNum = str.substring(0, idx);//截取从字符串开始到小数点位置的字符串，就是整数部分
            String hxid = strNum;
            Integer sex1 = 1;
            System.out.println("---------------------" + hxid);
            if (sex.equals("男")) {
                sex1 = 1;
            } else if (sex.equals("女")) {
                sex1 = 0;
            }
            int i = userMapper.insertUser(hxid, nickName, photo, sex1, hxid);
            User user = new User();
            user.setPass(hxid);
            user.setHxid(hxid);

            if (i == 1) {
                userVo.setUser(user);
                userVo.setTime("0");
                return userVo;
                //注册成功
            }
        }
        return null;
}

    @Override
    public int insertNorUser(String hxid, String pass,String nickName,String photo,String sex) {
        return userMapper.insertNorUser(hxid, pass,nickName,photo, Integer.valueOf(sex));
    }

    @Override
    public User getInfo(String hxid) {
        User oneInfo = userMapper.getOneInfo(hxid);

        return oneInfo;
    }

    @Override
    public int updateNick(String nickName,String hxid) {
        return userMapper.updateNick(nickName,hxid);
    }

    @Override
    public int updateSig(String Sig,String hxid) {

        return userMapper.updateSig(Sig,hxid);
    }

    @Override
    public int updateSex(Integer sex,String hxid) {
        return userMapper.updateSex(sex,hxid);
    }

    @Override
    public int updatePic(String url,String hxid) {
        return  userMapper.updatePic(url, hxid);
    }

    @Override
    public User getPic(String hxid) {
        return userMapper.getPic(hxid);
    }

}



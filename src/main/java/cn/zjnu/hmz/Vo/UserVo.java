package cn.zjnu.hmz.Vo;

import cn.zjnu.hmz.model.User;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/8/7.
 */
public class UserVo {
    private String time;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserVo() {
    }

    public UserVo(String time, User user) {

        this.time = time;
        this.user = user;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

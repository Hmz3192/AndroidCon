package cn.zjnu.hmz.model;

public class User {
    private Integer id;

    private String pass;

    private String hxid;

    private String nickname;

    private String photo;

    private Integer sex;

    private String signture;

    public User(Integer id, String pass, String hxid, String nickname, String photo, Integer sex, String signture) {
        this.id = id;
        this.pass = pass;
        this.hxid = hxid;
        this.nickname = nickname;
        this.photo = photo;
        this.sex = sex;
        this.signture = signture;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getHxid() {
        return hxid;
    }

    public void setHxid(String hxid) {
        this.hxid = hxid == null ? null : hxid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSignture() {
        return signture;
    }

    public void setSignture(String signture) {
        this.signture = signture == null ? null : signture.trim();
    }
}
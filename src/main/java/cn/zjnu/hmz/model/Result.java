package cn.zjnu.hmz.model;

/**
 * @Author Hu mingzhi
 * Created by Lenovo on 2017/7/9.
 */
public class Result {

    String image;
    String url;
    Integer option;


    public Result() {
    }
    public Result(String image, Integer option,String url) {
        this.image = image;
        this.url = url;
        this.option = option;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

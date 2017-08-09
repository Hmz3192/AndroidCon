package cn.zjnu.hmz.utils;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/8/8.
 */
public class subString {

    public static String subString(String url) {
        String urlNew = new String();
        for (int i = 46; i < url.length(); i++) {
            char item = url.charAt(i);
            urlNew += item;
        }
        System.out.println(urlNew);
        urlNew = "http://101.201.234.133:8080/" + urlNew;
        System.out.println(urlNew+"111");
        return urlNew;
    }
}

package cn.zjnu.hmz.utils;

import java.io.*;

/**
 * @Author Hu mingzhi
 * Created by Lenovo on 2017/7/10.
 */
public class ReadJson {

    public static void main(String[] args){
        String laststr="";
        String path = "C:\\Program Files (x86)\\java\\apache-tomcat-7.0.78\\webapps\\ROOT\\atguigu\\json\\HOME_URL.json";
        File file=new File(path);// 打开文件
        BufferedReader reader=null;
        try{
            FileInputStream in = new FileInputStream(file);
            reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));// 读取文件
            String tempString=null;
            while((tempString=reader.readLine())!=null){
                laststr=laststr+tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(IOException el){
                }
            }
        }
        System.out.println(laststr);
    }
}

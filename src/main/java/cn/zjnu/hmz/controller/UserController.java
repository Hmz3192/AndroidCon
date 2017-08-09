package cn.zjnu.hmz.controller;

import cn.zjnu.hmz.Vo.ResultBean;
import cn.zjnu.hmz.Vo.UserVo;
import cn.zjnu.hmz.model.User;
import cn.zjnu.hmz.service.UserService;
import cn.zjnu.hmz.utils.subString;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/8/7.
 */
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public UserVo register(String nickName, String photo, String sex) {
        UserVo userVo = userService.insertUser(nickName, photo, sex);
        userVo.getUser().setNickname(nickName);
        userVo.getUser().setPhoto(photo);
        int sex1 = 1;
        if (sex.equals("男")) {
            sex1 = 1;
        } else if (sex.equals("女")) {
            sex1 = 0;
        }
        userVo.getUser().setSex(sex1);
        return userVo;

    }


    @RequestMapping(method = RequestMethod.POST, value = "/registerHxUser")
    public void registerHxUser(String hxid, String pass) {
        String nickName = "0";
        String photo = "0";
        String sex = "3";
        userService.insertNorUser(hxid, pass, nickName, photo, sex);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getInfo")
    public User getInfo(String hxid) {
        User info = userService.getInfo(hxid);
        return info;

    }


    @RequestMapping(method = RequestMethod.POST, value = "/updateNick")
    public ResultBean updateNick(String nickName, String hxid) {
        ResultBean resultBean = new ResultBean();
        int i = userService.updateNick(nickName, hxid);

        resultBean.setReul(i);

        return resultBean;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateSex")
    public ResultBean updateSex(String sex, String hxid) {
        ResultBean resultBean = new ResultBean();

        Integer sex1;
        if (sex.equals("男")) {
            sex1 = 1;
        } else
            sex1 = 0;
        int i = userService.updateSex(sex1, hxid);
        resultBean.setReul(i);


        return resultBean;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateSig")
    public ResultBean updateSig(String sig, String hxid) {
        ResultBean resultBean = new ResultBean();

        int i = userService.updateSig(sig, hxid);
        resultBean.setReul(i);


        return resultBean;

    }


    @RequestMapping(method = RequestMethod.POST, value = "/updatePic")
    public ResultBean saveFileByPath(MultipartFile file, String hxid, HttpServletRequest request) throws IOException {
        String originalFileName = file.getOriginalFilename();
        System.out.println("============文件名：====" + originalFileName);


        // 新的图片名称
        String newFileName = hxid + originalFileName.substring(originalFileName.lastIndexOf("."));
        System.out.println(newFileName);
        File newFile = new File(request.getServletContext().getRealPath("/img") /*getRealPath("/upload/file")*//*filePath +"/"+ newFileName*/);//新图片
        System.out.println(newFile.toString());

        if (!newFile.exists()) {
            newFile.mkdir();
        }
            /*保存文件*/
        FileCopyUtils.copy(file.getBytes(), new File(newFile.toString() + "/" + newFileName));
//            file.transferTo(newFile);// 将内存中的数据写入磁盘


        String fileUrl = newFile + "/" + newFileName;
        /**/
        String urlFinal = subString.subString(fileUrl);
        System.out.println(fileUrl.toString());
        ResultBean resultBean = new ResultBean();
        if (userService.updatePic(urlFinal, hxid) == 1) {
            resultBean.setReul(1);
        } else
            resultBean.setReul(0);

        return resultBean;
    }



    @RequestMapping(method = RequestMethod.GET, value = "/getPic")
    public User getPic(String hxid) {
       return userService.getPic(hxid);

    }
}



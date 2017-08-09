package cn.zjnu.hmz.controller;

import cn.zjnu.hmz.model.Result;
import cn.zjnu.hmz.model.ResultBeanData;
import cn.zjnu.hmz.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Hu mingzhi
 * Created by Lenovo on 2017/7/9.
 */
@Controller
@RequestMapping("/new")
public class NewController {



    @Resource
    ResultService resultService;


    @ResponseBody
    @RequestMapping("/andro")
    public ResultBeanData retur(){

        /*获取list的result*/
        List<Result> result=resultService.selectDB();

        /*获得bannerinfobean对象*/
        List<ResultBeanData.ResultBean.BannerInfoBean> bannerInfoBeanList = new ArrayList<ResultBeanData.ResultBean.BannerInfoBean>();

        /*获得valuebean对象*/
        ResultBeanData.ResultBean.BannerInfoBean.ValueBean valueBean = new ResultBeanData.ResultBean.BannerInfoBean.ValueBean();


        /*将值转换到bannerinfobeanList中*/
        for (Result result1 : result) {
            ResultBeanData.ResultBean.BannerInfoBean bannerInfoBean1 = new ResultBeanData.ResultBean.BannerInfoBean();
            valueBean.setUrl(result1.getUrl());
            bannerInfoBean1.setValue(valueBean);
            bannerInfoBean1.setImage(result1.getImage());
            bannerInfoBean1.setOption(result1.getOption());
            bannerInfoBean1.setType(0);

           /* 加入到list中*/
            bannerInfoBeanList.add(bannerInfoBean1);

        }

         /*获得resultbean对象*/
        ResultBeanData.ResultBean resultBean = new ResultBeanData.ResultBean();
        /*转给resutbean*/
        resultBean.setBanner_info(bannerInfoBeanList);

        /*将数据最后处理给ResultBeanData*/
        ResultBeanData resultBeanData = new ResultBeanData();
        resultBeanData.setMsg("请求成功");
        resultBeanData.setCode(200);
        resultBeanData.setResult(resultBean);

        return resultBeanData;


    }

}

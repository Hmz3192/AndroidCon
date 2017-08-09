package cn.zjnu.hmz.service.impl;

import cn.zjnu.hmz.dao.ResultMapper;
import cn.zjnu.hmz.model.Result;
import cn.zjnu.hmz.service.ResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Hu mingzhi
 * Created by Lenovo on 2017/7/9.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResultServiceImpl implements ResultService {

    @Resource
    ResultMapper resultMapper;


    public List<Result> selectDB() {
        return resultMapper.selectDB();
    }
}

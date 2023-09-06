package cn.zzuli.yangoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zzuli.yangoj.model.entity.Question;
import cn.zzuli.yangoj.service.QuestionService;
import cn.zzuli.yangoj.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author lcyzh
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2023-09-06 14:14:01
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}





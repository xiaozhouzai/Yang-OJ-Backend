package cn.zzuli.yangoj.service;

import cn.zzuli.yangoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import cn.zzuli.yangoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import cn.zzuli.yangoj.model.entity.QuestionSubmit;
import cn.zzuli.yangoj.model.entity.User;
import cn.zzuli.yangoj.model.vo.QuestionSubmitVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lcyzh
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2023-09-06 14:17:01
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

        /**
         * 题目提交
         *
         * @param questionSubmitAddRequest 题目提交信息
         * @param loginUser
         * @return
         */
        Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);
}


package cn.zzuli.yangoj.service.impl;

import cn.zzuli.yangoj.common.ErrorCode;
import cn.zzuli.yangoj.exception.BusinessException;
import cn.zzuli.yangoj.exception.ThrowUtils;
import cn.zzuli.yangoj.mapper.QuestionSubmitMapper;
import cn.zzuli.yangoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import cn.zzuli.yangoj.model.entity.Question;
import cn.zzuli.yangoj.model.entity.QuestionSubmit;
import cn.zzuli.yangoj.model.entity.User;
import cn.zzuli.yangoj.model.enums.QuestionSubmitLanguageEnum;
import cn.zzuli.yangoj.service.QuestionService;
import cn.zzuli.yangoj.service.QuestionSubmitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author lcyzh
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2023-09-06 14:17:01
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{
    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private QuestionService questionService;

    @Override
    public Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        if (ObjectUtils.isEmpty(questionSubmitAddRequest)) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"请求为空");
        }
        // 校验编程语言是否合法
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言错误");
        }

        Long questionId = questionSubmitAddRequest.getQuestionId();
        Question question = questionService.getById(questionId);
        ThrowUtils.throwIf(ObjectUtils.isEmpty(question),ErrorCode.NOT_FOUND_ERROR,"该题目已被删除或者不存在");
        String code = questionSubmitAddRequest.getCode();
        Long userId = loginUser.getId();
        //TODO 设置初始状态
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(code);
        questionSubmit.setLanguage(language);
        questionSubmit.setUserId(userId);
        questionSubmit.setStatus(0);
        questionSubmit.setJudgeInfo("{}");
        boolean save = questionSubmitService.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"保存失败");
        }
        return questionSubmit.getId();
    }
}





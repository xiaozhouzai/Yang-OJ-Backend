package cn.zzuli.yangoj.controller;



import cn.zzuli.yangoj.common.BaseResponse;
import cn.zzuli.yangoj.common.ErrorCode;
import cn.zzuli.yangoj.common.ResultUtils;
import cn.zzuli.yangoj.exception.BusinessException;
import cn.zzuli.yangoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import cn.zzuli.yangoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import cn.zzuli.yangoj.model.entity.QuestionSubmit;
import cn.zzuli.yangoj.model.entity.User;
import cn.zzuli.yangoj.model.vo.QuestionSubmitVO;
import cn.zzuli.yangoj.service.QuestionSubmitService;
import cn.zzuli.yangoj.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
//@Deprecated 弃用
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录的 id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {

        //用户做完题目后提交
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //获取登录用户
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

}


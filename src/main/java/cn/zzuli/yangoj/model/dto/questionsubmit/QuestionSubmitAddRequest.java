package cn.zzuli.yangoj.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    private static final long serialVersionUID = -8076408514381139294L;
    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 题目 id
     */
    private Long questionId;
}

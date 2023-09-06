package cn.zzuli.yangoj.model.enums;

import cn.zzuli.yangoj.common.ErrorCode;
import cn.zzuli.yangoj.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

public enum QuestionSubmitLanguageEnum {
    JAVA("java",0),
    PYTHON("python",1)
    ;


    public final  String language;

    public final Integer code;

    QuestionSubmitLanguageEnum(String language, Integer code) {
        this.language = language;
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getCode() {
        return code;
    }
    public static QuestionSubmitLanguageEnum getEnumByValue(String language) {
        if (StringUtils.isBlank(language)) {
            return null;
        }
        for (QuestionSubmitLanguageEnum questionSubmitLanguageEnum : QuestionSubmitLanguageEnum.values()) {
            if (questionSubmitLanguageEnum.language.equals(language)) {
                return questionSubmitLanguageEnum;
            }
        }
        return null;

    }

}

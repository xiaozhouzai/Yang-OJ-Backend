package cn.zzuli.yangoj.model.dto.user;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserSendMessageRequest implements Serializable {
    private static final long serialVersionUID = 1121594034725387461L;
    private String userPhone;
}

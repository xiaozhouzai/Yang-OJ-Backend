package cn.zzuli.yangoj.model.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginUserVO implements Serializable {
    private static final long serialVersionUID = 9155197539865796649L;
    private Long id;
    private String userAvatar;
    private String userName;
    private String userPhone;
    private String userRole;
    private String userSignature;
    private String tags;
    private Date createTime;
    private Date updateTime;
}

package cn.zzuli.yangoj.model.dto.user;

import cn.zzuli.yangoj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = -185477715256393837L;
    protected Long id;
    protected String userName;
    protected String userRole;
}

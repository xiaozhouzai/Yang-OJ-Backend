package cn.zzuli.yangoj.service.impl;

import cn.zzuli.yangoj.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zzuli.yangoj.common.ErrorCode;
import cn.zzuli.yangoj.constant.CommonConstant;
import cn.zzuli.yangoj.mapper.UserBlogMapper;
import cn.zzuli.yangoj.model.dto.blog.UserBlogQueryRequest;
import cn.zzuli.yangoj.model.entity.UserBlog;
import cn.zzuli.yangoj.service.UserBlogService;
import cn.zzuli.yangoj.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserBlogServiceImpl extends ServiceImpl<UserBlogMapper, UserBlog> implements UserBlogService {
    @Override
    public QueryWrapper<UserBlog> getQueryWrapper(UserBlogQueryRequest userBlogQueryRequest) {
        if (userBlogQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        Long id = userBlogQueryRequest.getId();
        Long userId = userBlogQueryRequest.getUserId();
        String avatar = userBlogQueryRequest.getAvatar();
        String content = userBlogQueryRequest.getContent();
        String title = userBlogQueryRequest.getTitle();
        String sortField = userBlogQueryRequest.getSortField();
        String sortOrder = userBlogQueryRequest.getSortOrder();
        QueryWrapper<UserBlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        queryWrapper.eq(userId != null, "userId", userId);
        queryWrapper.like(StringUtils.isNotBlank(avatar), "avatar", avatar);
        queryWrapper.like(StringUtils.isNotBlank(title), "title", title);
        queryWrapper.like(StringUtils.isNotBlank(content), "content", content);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }
}

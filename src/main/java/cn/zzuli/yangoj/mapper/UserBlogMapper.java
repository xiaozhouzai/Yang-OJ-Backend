package cn.zzuli.yangoj.mapper;

import cn.zzuli.yangoj.model.entity.UserBlog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lcyzh
* @description 针对表【user_blog(我的博客)】的数据库操作Mapper
* @createDate 2023-08-21 00:49:27
* @Entity entity.model.cn.zzuli.yangoj.UserBlog
*/
@Mapper
public interface UserBlogMapper extends BaseMapper<UserBlog> {

}





package zx.app.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zx.app.web.model.AttachmentParam;

/**
 * @author chenk
 * @description 功能
 */
@Mapper
public interface AttachmentMapper {
    int insertUpload(AttachmentParam attachmentParam, @Param("userId")Integer userId);
}

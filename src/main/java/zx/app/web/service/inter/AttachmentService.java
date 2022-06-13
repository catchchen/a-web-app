package zx.app.web.service.inter;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenk
 * @description 功能
 */
public interface AttachmentService {

    boolean upload(MultipartFile file);
}

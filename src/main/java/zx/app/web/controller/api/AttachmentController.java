package zx.app.web.controller.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import zx.app.web.model.Response;
import zx.app.web.service.inter.AttachmentService;
import java.io.IOException;

/**
 * @author chenk
 */
@RestController
public class AttachmentController {
    private final AttachmentService attachmentService;
    public AttachmentController(AttachmentService attachmentService){
        this.attachmentService = attachmentService;
    }
    // 文件上传
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Response upload(MultipartFile file) throws IOException {
        boolean flag = attachmentService.upload(file);

        if(!flag){
            return Response.fail("上传失败");
        }
        return Response.ok("上传成功");
    }

}

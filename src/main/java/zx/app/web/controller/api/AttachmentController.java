package zx.app.web.controller.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zx.app.web.model.Response;
import zx.app.web.model.entity.Attachment;
import zx.app.web.service.inter.AttachmentService;
import zx.app.web.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author chenk
 */
@RestController("/api")
@Slf4j
public class AttachmentController {

    private final AttachmentService attachmentService;
    private final List<String> imgType = Arrays.asList("png", "jpeg", "jpg");
    public AttachmentController(AttachmentService attachmentService){
        this.attachmentService = attachmentService;
    }
    // 文件上传
    @PostMapping(value = "/{userId}/upload")
    public Response upload(@PathVariable("userId") Integer id,@RequestPart("img") MultipartFile file) throws IOException {
        // enctype="multipart/form-data"        name  =  img
        log.info("用户id：{}，上传文件名：{}", id, file.getSize());
//        file.getBytes() 获取文件的字节信息
// 如果为空
        if(!file.isEmpty()){
            return Response.fail("上传文件不能为空");
        }

        boolean flag = attachmentService.upload(file);
        if(!flag){
            return Response.fail("上传失败");
        }
        return Response.ok("上传成功");
    }
}

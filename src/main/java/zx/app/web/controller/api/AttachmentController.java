package zx.app.web.controller.api;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import zx.app.web.model.Response;
import zx.app.web.service.inter.AttachmentService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author chenk
 */

public class AttachmentController {
    private final AttachmentService attachmentService;
    public AttachmentController(AttachmentService attachmentService){
        this.attachmentService = attachmentService;
    }
    // 文件上传
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Response upload(MultipartFile file) throws IOException {
        // 文件上传的 原名
        String originalFilename = file.getOriginalFilename();
        // 获取文件拓展名
        String filename = originalFilename.substring(originalFilename.lastIndexOf("."));
        filename = UUID.randomUUID().toString() + filename;
        // 文件修改名字
        String filePath = ResourceUtils.getURL("classpath:").getPath().substring(1) + "static/img/";
        System.out.println(filePath);
//        attachmentService.save()
        FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(filePath + filename)));
        Map<String,String> path = new HashMap<>();
        // 返回给前端数据
        path.put("imgUrl","/api/img/"+filename);
        // 将
        return Response.ok(path);
    }
}

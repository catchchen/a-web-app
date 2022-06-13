package zx.app.web.service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import zx.app.web.mapper.AttachmentMapper;
import zx.app.web.service.inter.AttachmentService;
import zx.app.web.utils.FileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;


/**
 * @author chenk
 */
@Slf4j
@Service
public class AttachmentServiceImpl implements AttachmentService {
    private static String upload_path = "/resources/upload";
    private static final String PATH = "src/main/resources/resources/upload";
    private final AttachmentMapper attachmentMapper;
    public AttachmentServiceImpl(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
    }
    public boolean upload(MultipartFile file){
        // 文件上传的 原名
        String originalFilename = file.getOriginalFilename();
        // 获取文件拓展名  originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = FileUtil.getExtension(originalFilename);
        filename = UUID.randomUUID().toString() + filename;
        // 文件修改名字
        String filePath = null;
        try {
            // 类路径 下
            filePath = ResourceUtils.getURL("classpath:").getPath().substring(1) + "static/img/";
            log.info("upload file path:{}", filePath);
//        attachmentService.save()
            FileCopyUtils.copy(file.getInputStream(),
                    new FileOutputStream(new File(filePath + filename)));

            attachmentMapper.insertUpload();

            Map<String,String> path = new HashMap<>();
            // 返回给前端数据
            path.put("imgUrl","/api/img/"+filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.info("upload file fail");
            return false;
        } catch (IOException e) {
            log.info("upload file fail");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

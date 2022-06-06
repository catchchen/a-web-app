package zx.app.web.service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import zx.app.web.service.inter.AttachmentService;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenk
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    public boolean upload(MultipartFile file){
        // 文件上传的 原名
        String originalFilename = file.getOriginalFilename();
        // 获取文件拓展名
        String filename = originalFilename.substring(originalFilename.lastIndexOf("."));
        filename = UUID.randomUUID().toString() + filename;
        // 文件修改名字
        String filePath = null;
        try {
            filePath = ResourceUtils.getURL("classpath:").getPath().substring(1) + "static/img/";
            System.out.println(filePath);
//        attachmentService.save()
            FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(filePath + filename)));
            Map<String,String> path = new HashMap<>();
            // 返回给前端数据
            path.put("imgUrl","/api/img/"+filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

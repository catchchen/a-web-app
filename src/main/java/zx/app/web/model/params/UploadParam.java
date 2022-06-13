package zx.app.web.model.params;

import lombok.Data;

@Data
public class UploadParam {
    private Integer userId;
    private String path;
    private String suffix;

}

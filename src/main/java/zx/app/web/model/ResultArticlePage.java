package zx.app.web.model;

import lombok.Data;
import zx.app.web.model.vo.ArticleVo;
import java.util.List;

/**
 * @author chenk
 */
public class ResultArticlePage<D> {
    private D data;
    private Long total;

    public ResultArticlePage(D data, Long total) {
        this.data = data;
        this.total = total;
    }

    public static <D> ResultArticlePage success(D data, Long total){
        return new ResultArticlePage(data, total );
    }

    public static <D> ResultArticlePage fail() {
        return new ResultArticlePage(null,0l);
    }
}

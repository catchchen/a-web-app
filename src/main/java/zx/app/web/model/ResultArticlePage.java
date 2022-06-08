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
    private boolean hasPreviousPage;
    private boolean hasNextPage;

    public D getData() {
        return data;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public ResultArticlePage(D data, Long total, boolean hasPreviousPage, boolean hasNextPage) {
        this.data = data;
        this.total = total;
        this.hasPreviousPage=hasPreviousPage;
        this.hasNextPage=hasNextPage;
    }

    public static <D> ResultArticlePage success(D data, Long total, boolean hasPreviousPage,boolean hasNextPage){
        return new ResultArticlePage(data, total, hasPreviousPage, hasNextPage );
    }

    public static <D> ResultArticlePage fail() {
        return new ResultArticlePage(null,0l, false, false);
    }
}

package zx.app.web.model;

import lombok.Data;

/**
 * @author chenk
 */
@Data
public class ResultWithPage<D> {
    private D data;
    private Integer statusCode;
    private String msg;
    private Integer total;
}

package zx.app.web.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author chenk
 */
@Data
public class ResultWithPage<D> {
    private D data;
    private Integer total;
    private Integer statusCode;
    private String msg;

    public ResultWithPage(D data, Integer total, Integer statusCode, String msg) {
        this.data = data;
        this.total = total;
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public static <D> ResultWithPage success(D data, Integer total){
        return new ResultWithPage(data,total, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
}

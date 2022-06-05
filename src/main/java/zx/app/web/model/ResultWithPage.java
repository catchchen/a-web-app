package zx.app.web.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author chenk
 */
@Data
public class ResultWithPage<D> {
    private D data;
    private Long total;
    private Integer statusCode;
    private String msg;

    public ResultWithPage(D data, Long total, Integer statusCode, String msg) {
        this.data = data;
        this.total = total;
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public static <D> ResultWithPage success(D data, Long total){
        return new ResultWithPage(data,total, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public static <D> ResultWithPage fail(String msg) {
        return new ResultWithPage(null,0l,HttpStatus.BAD_REQUEST.value(),msg);
    }

}

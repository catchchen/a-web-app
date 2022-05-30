package zx.app.web.model;

import lombok.Data;

import java.util.Date;

/**
 * @author chenk
 */
@Data
public class UserQuery {
    private String username;
    private String email;
    private Date createTimeFrom;
    private Date createTimeTo;
}

package zx.app.web.model;

import lombok.Data;

/**
 * @author chenk
 */
@Data
public class AuthToken {
    private Integer id;
    private Boolean status;
    private String token;

    public AuthToken(Integer id, Boolean status, String token) {
        this.id = id;
        this.status = status;
        this.token = token;
    }
}

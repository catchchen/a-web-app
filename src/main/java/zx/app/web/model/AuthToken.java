package zx.app.web.model;

import lombok.Data;

/**
 * @author chenk
 */
@Data
public class AuthToken {
    private Integer id;
    private String token;

    public AuthToken(Integer id, String token) {
        this.id = id;
        this.token = token;
    }
}

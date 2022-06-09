package zx.app.web.model.entity;

/**
 * @author chenk
 */
public class Comment {
    private String author;

    /**
     * Commentator's email.
     */

    private String email;

    /**
     * Comment content.
     */

    private String content;

    /**
     * Is admin's comment.
     */
//    private Boolean isAdmin;

    /**
     * Post id.
     */

    private Integer articleId;

    /**
     * Parent comment.
     */

    private Long parentId;
}

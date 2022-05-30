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
     * Commentator's ip address.
     */

//    private String ipAddress;

    /**
     * Commentator's website.
     */

    private String authorUrl;

    /**
     * Gravatar md5
     */

    private String gravatar;

    /**
     * Comment content.
     */

    private String content;

    /**
     * Comment status.
     */
    private int status;

    /**
     * Commentator's userAgent.
     */
    private String userAgent;

    /**
     * Is admin's comment.
     */
//    private Boolean isAdmin;

    /**
     * Allow notification.
     */

    private Boolean allowNotification;

    /**
     * Post id.
     */

    private Integer postId;

    /**
     * Whether to top the comment.
     */

    private Integer topPriority;

    /**
     * Parent comment.
     */

    private Long parentId;
}

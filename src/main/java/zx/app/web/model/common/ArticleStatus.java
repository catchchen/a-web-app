package zx.app.web.model.common;

public enum ArticleStatus implements ValueEnum<Integer>{
    /**
     * 已发布
     */
    PUBLISHED(0),

    /**
     * Auditing status. 需要继续编写的
     */
    AUDITING(1),

    /**
     * 回收站
     */
    RECYCLE(2);

    private final Integer value;

    ArticleStatus(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}

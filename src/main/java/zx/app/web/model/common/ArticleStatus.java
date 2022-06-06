package zx.app.web.model.common;

public enum ArticleStatus implements ValueEnum<Integer>{
    /**
     * 已发布
     */
    PUBLISHED(1),

    /**
     * editing 需要继续编写的
     */
    EDITING(2),
    /**
     * 回收站
     */
    RECYCLE(3),


    DELETE(4);
    private final Integer value;

    ArticleStatus(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}


package chapter.project.chapter03.batis;

/**
 * @Date 2023/6/30 20:36
 * @注释
 */
public class BatisComment {
    private Integer id; //评论的id
    private String content; //评论的内容
    private String author; //评论的作者
    private Integer aId; //关联的文章id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "BatisComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", aId=" + aId +
                '}';
    }
}



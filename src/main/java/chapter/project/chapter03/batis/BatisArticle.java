package chapter.project.chapter03.batis;

import java.util.List;

/**
 * @Date 2023/7/1 14:04
 * @注释
 */
public class BatisArticle {

    private Integer id; //文章id
    private String title; //文章标题
    private String content; //文章内容
    private List<BatisComment> batisCommentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BatisComment> getBatisCommentList() {
        return batisCommentList;
    }

    public void setBatisCommentList(List<BatisComment> batisCommentList) {
        this.batisCommentList = batisCommentList;
    }

    @Override
    public String toString() {
        return "BatisArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", batisCommentList=" + batisCommentList +
                '}';
    }
}

package com.haberturk.entity;

import com.haberturk.database.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Content extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contentId")
    private long contentId;
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name="subNewsId")
    private SubNews subNews;

    public SubNews getSubNews() {
        return subNews;
    }

    public void setSubNews(SubNews subNews) {
        this.subNews = subNews;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

package com.haberturk.entity;

import com.haberturk.database.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubNews extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subNewsId")
    private long subNewsId;
    @Column(name = "subNewsTitle")
    private String subNewsTitle;

    @ManyToOne
    @JoinColumn(name = "newsId")
    private News news;

    @OneToMany(mappedBy = "subNews", cascade = CascadeType.ALL)
    private List<Content> contentList;

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public long getSubNewsId() {
        return subNewsId;
    }

    public void setSubNewsId(long subNewsId) {
        this.subNewsId = subNewsId;
    }

    public String getSubNewsTitle() {
        return subNewsTitle;
    }

    public void setSubNewsTitle(String subNewsTitle) {
        this.subNewsTitle = subNewsTitle;
    }

}

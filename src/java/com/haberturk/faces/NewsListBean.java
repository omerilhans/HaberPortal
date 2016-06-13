package com.haberturk.faces;

import com.haberturk.entity.News;
import com.haberturk.repository.NewsRepo;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "newsListBean")
@RequestScoped
public class NewsListBean {

    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public NewsListBean() {
// süzme filtreleme olmadığı için Httpden id istemiyoruz, tüm listeyi alıyoruz.
        NewsRepo repo = new NewsRepo();
        newsList = repo.list();
        repo.close();
    }

}

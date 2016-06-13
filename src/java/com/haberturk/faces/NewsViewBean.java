package com.haberturk.faces;

import com.haberturk.entity.News;
import com.haberturk.repository.NewsRepo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "newsViewBean")
@RequestScoped
public class NewsViewBean {

    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public NewsViewBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long newsId = 0;
        if (request.getParameter("newsId") != null) {
            newsId = Long.parseLong(request.getParameter("newsId"));

            if (newsId != 0) {
                NewsRepo repo = new NewsRepo();
                news = repo.find(newsId);
                repo.close();
            }
        }
    }
}

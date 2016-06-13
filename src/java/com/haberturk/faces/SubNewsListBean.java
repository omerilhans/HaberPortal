package com.haberturk.faces;

import com.haberturk.entity.SubNews;
import com.haberturk.repository.SubNewsRepo;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean (name="subNewsListBean")
@RequestScoped
public class SubNewsListBean {

    private List<SubNews> subNewsList;

    public List<SubNews> getSubNewsList() {
        return subNewsList;
    }

    public SubNewsListBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        long newsId = 0;
        if (request.getParameter("newsId") != null) {
            newsId = Long.parseLong(request.getParameter("newsId"));
        }
        SubNewsRepo repo = new SubNewsRepo();
        if(newsId == 0) {
            subNewsList = repo.list();
        } else {
            subNewsList = repo.listByHaberId(newsId);
        }
        repo.close();
    }

}

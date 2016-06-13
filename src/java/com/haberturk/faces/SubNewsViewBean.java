package com.haberturk.faces;

import com.haberturk.entity.SubNews;
import com.haberturk.repository.SubNewsRepo;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean (name="subNewsViewBean")
@RequestScoped
public class SubNewsViewBean {

    private SubNews subNews;

    public SubNews getSubNews() {
        return subNews;
    }

    public void setSubNews(SubNews subNews) {
        this.subNews = subNews;
    }

    public SubNewsViewBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long subNewsId = 0;
        if (request.getParameter("subNewsId") != null) {
            subNewsId = Long.parseLong(request.getParameter("subNewsId"));
        }
        SubNewsRepo repo = new SubNewsRepo();
        subNews = repo.find(subNewsId);
        repo.close();
    }

}

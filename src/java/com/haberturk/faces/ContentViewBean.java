package com.haberturk.faces;

import com.haberturk.entity.Content;
import com.haberturk.repository.ContentRepo;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "contentViewBean")
@RequestScoped
public class ContentViewBean {

    private Content content;

    public Content getContent() {
        return content;
    }

    public ContentViewBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long subNewsId = 0;
        if (request.getParameter("subNewsId") != null) {
            subNewsId = Long.parseLong(request.getParameter("subNewsId"));
        }
        ContentRepo repo = new ContentRepo();
        if(subNewsId == 0) {
            content = repo.find(subNewsId);
        } else {
            content = repo.findContentBySubNewsId(subNewsId);
        }
        repo.close();
    }

}

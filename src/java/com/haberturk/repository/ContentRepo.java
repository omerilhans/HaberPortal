package com.haberturk.repository;

import com.haberturk.database.BaseRepository;
import com.haberturk.entity.Content;
import javax.persistence.Query;

public class ContentRepo extends BaseRepository<Content> {

    public ContentRepo() {
        super(Content.class);
    }

    public Content findContentBySubNewsId(long subNewsId) {
        String jpql = super.createSelectSQL() + " where content.subNews.subNewsId=:subNewsId";
        Query query = super.entityManager.createQuery(jpql);
        query.setParameter("subNewsId", subNewsId);
        Content cont = (Content) query.getSingleResult();
        return cont;
    }

}

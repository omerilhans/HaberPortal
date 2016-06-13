package com.haberturk.repository;

import com.haberturk.database.BaseRepository;
import com.haberturk.entity.SubNews;
import java.util.List;
import javax.persistence.Query;

public class SubNewsRepo extends BaseRepository<SubNews> {

    public SubNewsRepo() {
        super(SubNews.class);
    }

    public List<SubNews> listByHaberId(long newsId) {
        String jpql = super.createSelectSQL() + " where subnews.news.newsId = :newsId";
        Query query = super.entityManager.createQuery(jpql);
        query.setParameter("newsId", newsId);
        return query.getResultList();
    }

}

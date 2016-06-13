
package com.haberturk.repository;

import com.haberturk.database.BaseRepository;
import com.haberturk.entity.News;

public class NewsRepo extends BaseRepository<News> {

    public NewsRepo() {
        super(News.class);
    }
    
}

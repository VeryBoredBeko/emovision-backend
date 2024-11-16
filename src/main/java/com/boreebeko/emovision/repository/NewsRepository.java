package com.boreebeko.emovision.repository;

import com.boreebeko.emovision.domain.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {}

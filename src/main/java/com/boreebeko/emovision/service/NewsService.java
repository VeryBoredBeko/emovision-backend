package com.boreebeko.emovision.service;

import com.boreebeko.emovision.domain.News;
import com.boreebeko.emovision.dto.NewsDTO;
import com.boreebeko.emovision.mapper.ApiMapper;
import com.boreebeko.emovision.repository.NewsRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final Validator validator;

    @Autowired
    public NewsService(NewsRepository newsRepository, Validator validator) {
        this.newsRepository = newsRepository;
        this.validator = validator;
    }

    public NewsDTO getById(Long id) {
        NewsDTO response = null;
        Optional<News> news = newsRepository.findById(id);

        if (news.isPresent()) {
            response = ApiMapper.INSTANCE.entityToDTO(news.get());
        }

        return response;
    }

    public List<NewsDTO> getAllNews() {
        ArrayList<News> newsArrayList = new ArrayList<>();
        newsRepository.findAll().forEach(newsArrayList::add);

        ArrayList<NewsDTO> newsDTOArrayList = new ArrayList<>();
        for (News news : newsArrayList) {
            newsDTOArrayList.add(ApiMapper.INSTANCE.entityToDTO(news));
        }

        return newsDTOArrayList;
    }

    public NewsDTO save(NewsDTO newsDTO) {
        return saveInformation(newsDTO);
    }

    public NewsDTO update(Long id, NewsDTO newsDTO) {
        return updateInformation(id, newsDTO);
    }

    public void delete(Long id) {}

    private NewsDTO saveInformation(NewsDTO newsDTO) {
        News entity = ApiMapper.INSTANCE.DTOtoEntity(newsDTO);

        Set<ConstraintViolation<News>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        News savedEntity = newsRepository.save(entity);
        return ApiMapper.INSTANCE.entityToDTO(savedEntity);
    }

    private NewsDTO updateInformation(Long id, NewsDTO newsDTO) {
        News entity = ApiMapper.INSTANCE.DTOtoEntity(newsDTO);
        News savedEntity = null;

        Set<ConstraintViolation<News>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        Optional<News> currentEntity = newsRepository.findById(id);

        if (currentEntity.isPresent()) {
            News updatedEntity = currentEntity.get();

            updatedEntity.setTitle(entity.getTitle());
            updatedEntity.setDescription(entity.getDescription());
            updatedEntity.setText(entity.getText());

            savedEntity = newsRepository.save(updatedEntity);
        }

        return ApiMapper.INSTANCE.entityToDTO(savedEntity);
    }
}

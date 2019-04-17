package com.epam.newsmanagement.ejb.dtoConverter;

import com.epam.newsmanagement.ejb.dto.NewsDTO;
import com.epam.newsmanagement.ejb.entity.News;
import java.sql.Date;

public class NewsDTOConverter {
    public static NewsDTO Entity2DTO(News entity) {
        NewsDTO dto = new NewsDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDate(entity.getDate().toString());
        dto.setBrief(entity.getBrief());
        dto.setContent(entity.getContent());

        return dto;
    }

    public static News DTO2Entity(NewsDTO dto) {
        News entity = new News();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDate(Date.valueOf(dto.getDate()));
        entity.setBrief(dto.getBrief());
        entity.setContent(dto.getContent());
        entity.setUsername(dto.getUsername());

        return entity;
    }
}

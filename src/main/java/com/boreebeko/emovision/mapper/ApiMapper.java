package com.boreebeko.emovision.mapper;

import com.boreebeko.emovision.domain.Comment;
import com.boreebeko.emovision.domain.News;
import com.boreebeko.emovision.dto.CommentDTO;
import com.boreebeko.emovision.dto.NewsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiMapper {

    ApiMapper INSTANCE = Mappers.getMapper(ApiMapper.class);

    News DTOtoEntity(NewsDTO newsDTO);

    NewsDTO entityToDTO(News news);

    CommentDTO commentDtoToEntity(Comment comment);

    @Mapping(target = "news", ignore = true)
    Comment commentEntityToDto(CommentDTO commentDTO);
}

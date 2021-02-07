package com.kablanfatih.content.service.impl;

import com.kablanfatih.content.dto.ContentDto;
import com.kablanfatih.content.entity.Content;
import com.kablanfatih.content.entity.ContentStatus;
import com.kablanfatih.content.entity.es.ContentEs;
import com.kablanfatih.content.repository.ContentRepository;
import com.kablanfatih.content.repository.es.ContentElasticRepository;
import com.kablanfatih.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository repository;
    private final ContentElasticRepository esRepository;
    private final ModelMapper modelMapper;

    @Override
    public ContentDto save(ContentDto contentDto) {
        //TODO get segmentation from Company service
        Content content = new Content();
        content.setTitle(content.getTitle());
        content.setDescription(content.getDescription());
        content.setImage(content.getImage());
        content.setSendDate(content.getSendDate());
        content.setContentStatus(ContentStatus.valueOf("CREATED"));
        content = repository.save(content);
        saveEs(content);
        return modelMapper.map(content, ContentDto.class );
    }

    @Override
    public ContentDto update(String id, ContentDto contentDto) {
        return null;
    }

    @Override
    public ContentDto getById(String id) {
        return null;
    }

    @Override
    public Page<ContentDto> getPagination(Pageable pageable) {
        return null;
    }

    public void saveEs(Content content) {
        ContentEs contentEs = ContentEs.builder()
                .id(content.getId())
                .title(content.getTitle())
                .description(content.getDescription())
                .image(content.getImage())
                .sendDate(content.getSendDate())
                .contentStatus(ContentStatus.valueOf(content.getContentStatus().getLabel())).build();

        esRepository.save(contentEs);
    }
}

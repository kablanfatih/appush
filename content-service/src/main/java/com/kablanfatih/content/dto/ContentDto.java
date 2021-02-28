package com.kablanfatih.content.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {

    private String id;

    private String title;

    private String description;

    private String image;

    private Date sendDate;

    private String contentStatus;
}

package com.kablanfatih.content.entity.es;

import com.kablanfatih.content.entity.ContentStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(indexName = "contents")
public class ContentEs implements Serializable {

    @Id
    private String id;

    private String title;

    private String description;

    private String image;

    private String segmentation;

    private Date sendDate;

    private String contentStatus;
}

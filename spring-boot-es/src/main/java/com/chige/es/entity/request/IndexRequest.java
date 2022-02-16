package com.chige.es.entity.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class IndexRequest {

    private Integer _id;
    @NotBlank
    private String indexName;
}

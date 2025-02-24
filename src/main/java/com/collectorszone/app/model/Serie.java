package com.collectorszone.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "series")
public class Serie {

    @Column(nullable = false)
    private String owner;

    @EmbeddedId
    private SerieId serieId;

    private String description;

    private Integer startYear;

    private Integer endYear;

    private String rating;

    private String type;

    private Date modified;

    @Embedded
    private Thumbnail thumbnail;
}

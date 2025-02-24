package com.collectorszone.app.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Thumbnail {

    private String path;
    private String extension;

    public String getFullUrl() {
        return path + "." + extension;
    }
}

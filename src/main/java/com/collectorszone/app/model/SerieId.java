package com.collectorszone.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SerieId implements Serializable {

    @JsonProperty("id")
    private Integer serieId;

    private String title;

    public SerieId(Integer serieId, String title) {
        this.serieId = serieId;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerieId serieId1 = (SerieId) o;
        return Objects.equals(serieId, serieId1.serieId) &&
                Objects.equals(title, serieId1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serieId, title);
    }
}

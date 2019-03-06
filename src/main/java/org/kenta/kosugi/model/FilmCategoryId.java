package org.kenta.kosugi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FilmCategoryId implements Serializable {

    @Column(name = "film_id", length = 5)
    public long filmId;

    @Column(name = "category_id", length = 5)
    public long categoryId;

}

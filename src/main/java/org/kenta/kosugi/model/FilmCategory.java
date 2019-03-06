package org.kenta.kosugi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "film_category")
public class FilmCategory implements Serializable {

    @EmbeddedId
    public FilmCategoryId id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    public Date lastUpdate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "category_id", referencedColumnName = "category_id")
    public Category category;

}

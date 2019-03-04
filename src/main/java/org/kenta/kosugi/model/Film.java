package org.kenta.kosugi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "film", indexes = {
        @Index(name = "idx_fk_language_id", columnList = "language_id"),
        @Index(name = "idx_fk_original_language_id", columnList = "original_language_id"),
        @Index(name = "idx_title", columnList = "title")
})
@NamedQueries({
        @NamedQuery(name = "allFilm", query = "select a from Film a")
})
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "film_id", length = 5)
    public long filmId;

    @Column(name = "title", length = 255)
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "release_year", length = 4)
    public String releaseYear;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "language_id", referencedColumnName = "language_id")
    public Language language;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    public Language originalLanguage;

    @Column(name = "rental_duration")
    public long rentalDuration;

    @Column(name = "rental_rate")
    public double rentalRate;

    @Column(name = "length")
    public long length;

    @Column(name = "replacement_cost")
    public double replacementCost;

    @Column(name = "rating")
    public String rating;

    @Column(name = "special_features")
    public String specialFeatures;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    public Date lastUpdate;

}

package org.kenta.kosugi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * City class.
 *
 * @author Kenta Kosugi
 */
@Entity
@Table(name = "city", indexes = {
        @Index(name = "idx_fk_country_id", columnList = "country_id")
})
public class City implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "city_id", length = 5)
  public long cityId;

  @Column(name = "city", length = 50)
  public String city;

  @Column(name = "country_id", length = 5)
  public long countryId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_update")
  public Date lastUpdate;

}

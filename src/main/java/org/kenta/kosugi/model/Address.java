package org.kenta.kosugi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Address class.
 *
 * @author Kenta Kosugi
 */
@Entity
@Table(name = "address", indexes = {
        @Index(name = "idx_fk_city_id", columnList = "city_id"),
        @Index(name = "idx_location", columnList = "location")
})
@NamedQueries({
        @NamedQuery(name = "allAddress", query = "select a from Address a")
})
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "address_id")
  public long addressId;

  @Column(name = "address", length = 50)
  public String address;

  @Column(name = "address2", length = 50)
  public String address2;

  @Column(name = "district", length = 20)
  public String district;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @PrimaryKeyJoinColumn(name = "city_id", referencedColumnName = "city_id")
  public City city;

  @Column(name = "postal_code", length = 10)
  public String postalCode;

  @Column(name = "phone", length = 20)
  public String phone;

  @Column(name = "location")
  public String location;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_update")
  public Date lastUpdate;

}

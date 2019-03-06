package org.kenta.kosugi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "language")
public class Language extends SuperModel {

  @Id
  @Column(name = "language_id")
  public long languageId;

  @Column(name = "name", length = 20)
  public String name;

}

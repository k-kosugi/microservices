package org.kenta.kosugi.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category extends SuperModel {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "category_id", length = 3)
  public long categoryId;

  @Column(name = "name")
  public String name;

}

package org.kenta.kosugi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "film_category")
public class FilmCategory extends SuperModel {

  @EmbeddedId
  public FilmCategoryPK filmCategoryPK;

}

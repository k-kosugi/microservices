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
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @Column(name = "category_id", length = 3)
    public long categoryId;

    @Column(name = "name", precision = 25)
    public String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    public Date lastUpdate;
  
}

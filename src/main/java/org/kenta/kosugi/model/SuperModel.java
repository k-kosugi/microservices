package org.kenta.kosugi.model;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class SuperModel implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    public Date lastUpdate;

}

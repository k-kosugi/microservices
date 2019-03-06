package org.kenta.kosugi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Actor class.
 *
 * @author Kenta Kosugi
 */
@Entity
@Table(name = "actor", indexes = {
        @Index(name = "idx_actor_last_name", columnList = "last_name")
})
public class Actor extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "actor_id")
    public long actorId;

    @Column(name = "first_name", length = 45)
    public String firstName;

    @Column(name = "last_name", length = 45)
    public String lastName;

}

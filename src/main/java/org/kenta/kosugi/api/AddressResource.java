package org.kenta.kosugi.api;

import org.kenta.kosugi.model.Address;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 *
 * @author Kenta Kosugi
 */
@Path("/address")
@RequestScoped
public class AddressResource {

    @PersistenceContext(name = "docker_mysql_prod")
    private EntityManager em;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getAll(){
        return this.em.createNamedQuery("findAll", Address.class)
                .getResultList();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Address get(@QueryParam(value="id") long id){
        return this.em.find(Address.class, id);
    }

}

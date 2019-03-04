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
 * WebAPI for Address Table.
 *
 * @author Kenta Kosugi
 */
@Path("/address")
@RequestScoped
public class AddressResource {

    /**
     * Persistence Context.
     * Injects the DataSource defined in persistence.xml when ApplicationServer starts up.
     */
    @PersistenceContext(name = "docker_mysql_prod")
    private EntityManager em;

    /**
     * Return all the lines currently registered in the Address table in JSON format.
     * @return Return all Address objects currently registered in the Address table.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getAll(){
        return this.em.createNamedQuery("allAddress", Address.class)
                .getResultList();
    }

    /**
     * Return only the Address object associated with a specific id.
     * @param id Specify the address_id of the Address object you want to search.
     * @return Return the Address object associated with the address_id of the argument.
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Address get(@QueryParam(value="id") long id){
        return this.em.find(Address.class, id);
    }

}

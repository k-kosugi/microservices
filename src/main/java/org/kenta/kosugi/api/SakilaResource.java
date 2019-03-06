package org.kenta.kosugi.api;

import org.kenta.kosugi.model.Address;
import org.kenta.kosugi.model.Film;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 *
 * @author Kenta Kosugi
 */
@RequestScoped
@Path("/sakila")
public class SakilaResource {

    @PersistenceContext(name = "docker_mysql_prod")
    private EntityManager em;

    @GET
    @Path("/film/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film findFilm(@PathParam(value = "id") long id){
        return this.em.find(Film.class, id);
    }

    @GET
    @Path("/film/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getFilmBytitle(@PathParam(value = "name") String name){
        return this.em.createNamedQuery("filmByTitle", Film.class)
                .setParameter("title", name)
                .getResultList();
    }

    @GET
    @Path("/films")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getAllFilms(){
        return this.em.createNamedQuery("allFilm", Film.class)
                .getResultList();
    }

    /**
     * Return all the lines currently registered in the Address table in JSON format.
     * @return Return all Address objects currently registered in the Address table.
     */
    @GET
    @Path("/addresses")
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
    @Path("/address/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address get(@PathParam(value="id") long id){
        return this.em.find(Address.class, id);
    }

}

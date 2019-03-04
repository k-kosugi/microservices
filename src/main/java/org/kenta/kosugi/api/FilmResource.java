package org.kenta.kosugi.api;

import org.kenta.kosugi.model.Film;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/film")
public class FilmResource {

    @PersistenceContext(name = "docker_mysql_prod")
    private EntityManager em;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> all(){
        return this.em.createNamedQuery("allFilm", Film.class)
                .getResultList();
    }

}

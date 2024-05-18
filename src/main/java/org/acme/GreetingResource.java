package org.acme;

import org.acme.dominio.Person;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/q")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/nombre/{mote}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response gUsuaria(@PathParam("mote") String mote) {
        String nombrePersona = service.nombrePersona(mote);
        return Response.status(Response.Status.OK).entity(nombrePersona).build();
    }

    @GET
    @Path("/persona/{mote}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gPersona(@PathParam("mote") String mote) {
        Person persona = service.getPersona(mote);
        return Response.status(Response.Status.OK).entity(persona).build();
    }


    @GET
    @Path("/personas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response tot(){
        System.out.println(service.todos());
        return Response.status(Response.Status.OK).entity(service.todos()).build();
    }


    @Path("/nuevo/{mote}/{nombre}/{apellido}")
    @Transactional
    public void nuevaPersona(@PathParam("mote") String mote, @PathParam("nombre") String nombre, @PathParam("apellido") String apellido ){
        Person nuevo = new Person(mote, nombre, apellido, 18);
        nuevo.persist();
    }

    @Path("/actualizar/edad")
    @Transactional
    public void actualizaredad(){
        for (Person person: service.todos()){
            person.avanzarEdad();
        }
    }
}

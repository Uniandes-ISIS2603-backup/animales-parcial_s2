package co.edu.uniandes.csw.animales.resources;


import co.edu.uniandes.csw.animales.dtos.AnimalDetailDTO;
import co.edu.uniandes.csw.animales.ejb.AnimalLogic;
import co.edu.uniandes.csw.animales.entities.AnimalEntity;
import co.edu.uniandes.csw.animales.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animales.mappers.BusinessLogicExceptionMapper;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

@Path("animales")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AnimalResource {
    
    @Inject
    private AnimalLogic animalLogic;

    
    @POST
    public AnimalDetailDTO createAnimal(AnimalDetailDTO animal) throws BusinessLogicException {
        AnimalEntity animalEntity = animal.toEntity();
        animalEntity = animalLogic.createAnimal(animalEntity); 
        return new AnimalDetailDTO(animalEntity);
    }


    @GET
    @Path("{id: \\d+}")
    public AnimalDetailDTO getAnimal(@PathParam("id") Long id) {
        AnimalEntity animal = animalLogic.getAnimal(id);
        if (animal == null) 
            throw new WebApplicationException("La animal no existe");
        return new AnimalDetailDTO(animal); 
    }
    
 
}

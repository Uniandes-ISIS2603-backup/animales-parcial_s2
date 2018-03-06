/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.animales.persistence;

import co.edu.uniandes.csw.animales.entities.AnimalEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class AnimalPersistence {

    private static final Logger LOGGER = Logger.getLogger(AnimalPersistence.class.getName());

    @PersistenceContext(unitName = "AnimalPU")
    protected EntityManager em;

   
 
    /**
     * Busca si hay alguna animal con el nombre que se envía de argumento
     *
     * @param name: Nombre de la animal que se está buscando
     * @return null si no existe ninguna animal con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public AnimalEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando animal por nombre ", name);

        // Se crea un query para buscar animales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From AnimalEntity e where e.name = :name", AnimalEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<AnimalEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

  
    public AnimalEntity find(Long id) {
        return em.find(AnimalEntity.class, id);
    }

}

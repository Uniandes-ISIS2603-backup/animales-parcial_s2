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
package co.edu.uniandes.csw.animales.dtos;

import co.edu.uniandes.csw.animales.entities.AnimalEntity;

/**
 * Clase que extiende de {@link AnimalDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la animal vaya a la documentacion de {@link AnimalDTO}
 *
 * @xyz ISIS2603
 */
public class AnimalDetailDTO extends AnimalDTO {

    
    /**
     * Constructor por defecto
     */
    public AnimalDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de animal a partir de la cual se construye el
     * objeto
     */
    public AnimalDetailDTO(AnimalEntity entity) {
        super(entity);

        //   if (entity.getXyzs()!= null)
        //  this.xyz = new XYZDTO(entity.getXyzs());
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public AnimalEntity toEntity() {
        AnimalEntity animalE = super.toEntity();
//        if (this.xyz != null) {
        //           animalE.setXyz(this.xyz.toEntity());
        //     }
        return animalE;
    }

}

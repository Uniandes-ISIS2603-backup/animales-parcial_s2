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


public class AnimalDTO {

    private Long id;
    private String name;
    private String especie;

    /**
     * Constructor por defecto
     */
    public AnimalDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param animal: Es la entidad que se va a convertir a DTO
     */
    public AnimalDTO(AnimalEntity animal) {
        this.id = animal.getId();
        this.name = animal.getName();
        this.especie = animal.getespecie();

    }

    /**
     * @return El ID de la animal
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El nombre de la animal
     */
    public String getName() {
        return name;
    }

    /**
     * @param name El nuevo nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return El especie de la animal
     */
    public String getespecie() {
        return especie;
    }

    /**
     * @param especie El nuevo especie
     */
    public void setespecie(String especie) {
        this.especie = especie;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public AnimalEntity toEntity() {
        AnimalEntity entity = new AnimalEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setespecie(this.especie);
        return entity;
    }
}

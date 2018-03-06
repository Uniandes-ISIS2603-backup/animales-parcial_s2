# Instrucciones

1. Abra los proyectos en Netbeans

2. En Netbeans Vaya a Services, Databases, JavaDB y cree una base de datos que 
se llame animalDB (los demás campos dejelos en blanco)

3. Cada vez que complete un paso genere un commit

4. Al finalizar ingrese a github y genere un release con el nombre Entrega_Parcial

## Punto 1. Ud debe completar el servicio que permite crear un animal. 

Tenemos un Recurso Animal que representa los animales que están alojados en un zoologico. 
De cada animal se conoce su nombre (name), su especie (ambos String), fecha nacimiento (Date) y se tiene un campo 
id de especie Long que representa la llave primaria del animal. 

 Para esto Ud. debe:

1. (10%) Crear la clase AnimalEntity con los atributos (se da la clase BaseEntity para que su clase 
extienda de ella y herede el `Long id` como llave primaria)

2. (10%) Completar en la clase AnimalPersistence el método que permite crear el animal. 
Se debe llamar `create`: recibe y retorna un `AnimalEntity`

3. (15%) Defina el método createAnimal de la clase AnimalLogic, el cual recibe un objeto 
AnimalEntity y valida las siguientes reglas de negocio:
1) Que no exista un animal con el mismo nombre
2) La fecha de nacimiento del animal debe ser anterior a la fecha actual
3) Que la especie del animal sea válida (utilice el método dado en la clase AnimalLogic).
Si ambas reglas de negocio se cumplen, se debe llamar la persistencia para que 
el objeto sea persistido, de lo contrario debe lanzar una excepción 
BussinessLogiException con un mensaje donde se especifique cual regla no se cumplió.

4. (15%) Completar el método createAnimalTest el cual prueba que el animal se está creando correctamente.

Ejecutar el programa y probar en postman el servicio:

`POST localhost:8080/animales-web/api/animales`

a. Ingresar el siguiente json: 

`{ 
  "name": "Felpudo",
  "especie": "E-Gato",
  "fechaNacimiento": "2018-02-22T20:38:54.973-05:00"
}`

Guarde una pantalla del resultado en  un archivo llamado postok.jpg en la carpeta
 `images` en el proyecto raiz.

b. Ingresar el siguiente json;

`{ 
  "name": "Minino",
  "especie": "Gato",
  "fechaNacimiento": "2018-02-22T20:38:54.973-05:00"
}`

Guarde una pantalla del resultado en  un archivo llamado postnook.jpg en la carpeta
 `images` en el proyecto raiz.


## Punto 2: Un animal se aloja en un Zoo. Cada zoo  tiene un name (String) y de nuevo un Long id que es la llave primaria.
Ud. debe extender su programa para que cuando ejecute 

`POST localhost:8080/animales-web/api/animales`

con el json:

`{ 
  "name": "Rochi",
  "especie": "E-Perro",
  "zoo": {
              "name": "Zoologico de Bogota"
            }
}`

Se cree el animal con la información del zoo. 

Para esto Ud. debe:

1. (15%) Crear las clases ZooDTO y ZooEntity que modelan el Zoo.  

En la clase ZooDTO, además de tener un constructor sin parámetros, 
para convertir un ZooEntity en un ZooDTO defina el siguiente constructor:

public ZooDTO(ZooEntity zoo) {
        ...
    }

Para convertir una ZooDTO  en una ZooEntity defina el siguiente método:

public ZooEntity toEntity() {
        ...
    }

2. (15%) Defina un atributo nuevo en AnimalDetailDTO que representa el zoo donde 
se aloja el animal. Defina set/get y actualice los demás métodos con el nuevo 
atributo incluyendo el constructor que recibe un ZooEntity y el método toEntity. 

3. (10%) Defina en AnimalEntity la relación con zoo (unidireccional). Está es una relación de muchos 
a uno (ManyToOne). Para lograr que cuando se cree el animal se cree también el zoo, debe agregar la anotación que permite crear en cascada.

4. (10%) Modifique la prueba de CreateAnimalTest para que ahora valide la creación del zoológico del animal.

4. Ejecute 

a. `POST localhost:8080/animales-web/api/animales`

con el json:

`{ 
  "name": "Roco",
  "especie": "E-Perro",
  "zoo": {
              "name": "Zoologico de Cali"
            }
}`

b. Fijese en el id que retornó el POST y Ejecute 

`GET localhost:8080/animales-web/api/animales/idqueretornoelpostanterior`


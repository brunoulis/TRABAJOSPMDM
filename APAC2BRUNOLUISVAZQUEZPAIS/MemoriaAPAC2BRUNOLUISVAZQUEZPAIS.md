
# APAC2

## Memoria

### 1. Introducción
El trabjo consiste en una aplicacion que mostrara todas las incidencias ocurridas.
En la que podras editar,crear y eliminar incidencias. Con sus respectivos dialogos.

### 2. Data Class Incidencia
En esta clase se crean los atributos de la clase, los cuales son:
- id    int
- assumpte  String
- descripcio    String
- ubicacio  String 
- servei    String con opciones que despues pondremos en el spinner 
  como Jardineria ,Infraestructuras ,Obres
- img       Int
- resolt    booleano

### 3. Clase Incidencies
Se crea la lista de incidencias y se le añade un metodo para añadir incidencias a la lista.

### 4. Clase IncidenciaAdapter 
Se crea el adaptador para la lista de incidencias, en el que se hacen llamadas a otras clases para que se muestren en la lista.

### 5. Clase IncidenciaViewHolder
Se crea el viewholder para la lista de incidencias en la cual mostramos en la lista tres valores de cada incidencia, en el que se le ha llamado
desde la clase IncidenciaAdapter.

### 6. Clase MainActivity
En esta clase se crea el menu de la aplicacion, en el que se le añade un boton y clicklistener para que al pulsar el boton se abra el dialogo de editar la incidencia.Se crea el recyclerview y se le añade el adaptador y el layoutmanager.

### 7. Clase MyDialogFragment
En esta clase se crea el dialogo para editar la incidencia, devolvera un string 
el cual cambiara segund se a cancelado o se ha guardado la incidencia.

### 8. Valores
Vemos el siguiente codigo:
El xml de tipos de servicios:
```xml <?xml version="1.0" encoding="utf-8"?>
<resources>
    <string-array name="TiposServeis">
        <item>Servei</item>
        <item>Jardineria</item>
        <item>Infraestructures</item>
        <item>Obres</item>
    </string-array>
</resources>
```
El xml de los Strings:
```xml <?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">APAC2</string>
    <string name="textViewdescripcion">Add your isue descripcion</string>
    <string name="askRemoveTitle">Remove Contact</string>
    <string name="askRemove">Are you sure to remove contact?</string>
    <string name="ActionCancelled">Delete has been cancelled</string>
    <string name="Save">SAVE</string>
</resources>
```

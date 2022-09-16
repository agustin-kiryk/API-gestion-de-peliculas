![](https://www.alkemy.org/static/media/alkemyLogo.2daef856.svg)

# Agustin Kiryk 
## Pre Aceleracion  JAVA SPRING BOOT API REST

## Comenzando 🚀


_Esta API rest permite realizar un catalogo de peliculas haciendo enfasis en las acciones de creacion, edicion, eliminacion y relacion de generos, peliculas y personajes, que seran guardados en su base de datos._

### Construccion 🔧

_El modelado de la base de datos con sus respectivas relaciones se realiza automaticamente con JPA e Hibernate al levantar la aplicacion.
Dentro del proyecto en la carpeta **resources/application.properties** se debe poner su url con la ubicacion de su base de datos, usuario y contraseña, como el siguiente ejemplo._
```
- spring.datasource.url=jdbc:mysql://localhost:3306/NOMBREBDD
```
```
- spring.datasource.username=USUARIO
```
```
- spring.datasource.password=CONTRASEÑA
```

_En este caso se usó Mysql, local host y el puerto 3036_

### Configuracion de envio de Email en el registro 📧

_Para ingresar al sistema debe registrar un nombre de usuario y una contraseña, el sistema envia un mail de bienvenida el cual se configura desde **resources/application.properties** segun el siguiente ejemplo_ 
```
alkemy.disney.email.sender= ejemplo@gmail.com  (Nombre del remitente del mail)
```
_Puede tambien configurar el contenido del mail en :_
```
/service/impl/EmailServiceImpl.java
```
_Se recomienda registrarce en https://signup.sendgrid.com/ para crear un usuario y obtener una API_KEY que será configurada en **environment variables** dentro de la aplicacion_

### Registro 📁

_Ingresar un nombre de usuario y contraseña para que sea guardado en su base de datos, esta ultima será encriptada por seguridad_

_Vea el siguiente ejemplo:_

![](https://github.com/agustin-kiryk/Pre-aceleracion-Agustin-Kiryk/blob/main/src/main/resources/static/registro11.png?raw=true)

### Iniciar secion ✅
_Una vez registrado, para iniciar secion se debe ingresar el nombre de usuario y contraseña. El sistema brindará un token JWT que tendra un tiempo de expiración, el cual puede ser configurado desde el metodo **createtoken**, ubicado en :_
```
auth/Service/JwtUtils.java
```
_Ejemplo_

![](https://github.com/agustin-kiryk/Pre-aceleracion-Agustin-Kiryk/blob/main/src/main/resources/static/login1.png?raw=true)

### End points para realizar las operaciones de creacion / edicion / eliminacion de entidades 📝

_Ejemplo de creacion de Genero_

![](https://github.com/agustin-kiryk/Pre-aceleracion-Agustin-Kiryk/blob/main/src/main/resources/static/generos1.png?raw=true)


### Puede ver la documentacion de todos los Endpoints e interactuar en el siguiente link👇  https://documenter.getpostman.com/view/22927578/2s7YfLhvX6#eef4c69c-c7f3-4295-8084-434eda85f89f


## Construido con 🛠️

_Para realizar este pryecto se usaron las siguientes herramientas_

* 👉 ide : IJ idea
* 👉 lenguaje : JAVA
* 👉 [Maven](https://maven.apache.org/) - Manejador de dependencias
* 👉 Spring Boot
* 👉 JPA
* 👉 Hibernate
* 👉 ORM : Dbiever
* 👉 Mysql
* 👉 SendGrid
* 👉 JWT Token
* 👉 Postman


## Autor ✒️

* **Kiryk Agustin**

## Licencia 📄

🎁 Este proyecto no está bajo la Licencia para que pueda ayudar a las personas que se estan iniciando 🎁




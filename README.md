![](https://www.alkemy.org/static/media/alkemyLogo.2daef856.svg)

# Agustin Kiryk 
## Pre Aceleracion  JAVA SPRING BOOT API REST

## Comenzando 🚀


_Esta API rest permite realizar las acciones de creacion, edicion y eliminacion de generos, peliculas y personajes de disney, cumpliendo con las consiganas preestablecidas._

### Construccion 🔧

_El modelado de la base de datos con sus respectivas relaciones se realiza automaticamente con JPA e Hibernate al levantar la aplicacion.
Dentro del proyecto en la carpeta resources/application.properties se debe poner su url con la ubicacion de su base de datos, usuario y contraseña, como el siguiente ejemplo._
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

## Configuracion de envio de Email en el registro ⚙️

_Para ingresar al sistema debe registrar un nombre de usuario y una contraseña, el sistema envia un mail de bienvenida el cual se configura desde resources/application.properties segun el siguiente ejemplo_ 
```
alkemy.disney.email.sender= ejemplo@gmail.com  (Nombre del remitente del mail)
```
_Puede tambiane configurar el contenido del mail en :_
```
/service/impl/EmailServiceImpl.java
```
_Se recomienda registrarce en https://signup.sendgrid.com/ para crear un usuario y obtener una API_KEY que será configurada en environment variables dentro de la aplicacion_

### Registro 🔩

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

### Y las pruebas de estilo de codificación ⌨️

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [ROME](https://rometools.github.io/rome/) - Usado para generar RSS

## Contribuyendo 🖇️

Por favor lee el [CONTRIBUTING.md](https://gist.github.com/villanuevand/xxxxxx) para detalles de nuestro código de conducta, y el proceso para enviarnos pull requests.

## Wiki 📖

Puedes encontrar mucho más de cómo utilizar este proyecto en nuestra [Wiki](https://github.com/tu/proyecto/wiki)

## Versionado 📌

Usamos [SemVer](http://semver.org/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/tu/proyecto/tags).

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Andrés Villanueva** - *Trabajo Inicial* - [villanuevand](https://github.com/villanuevand)
* **Fulanito Detal** - *Documentación* - [fulanitodetal](#fulanito-de-tal)

También puedes mirar la lista de todos los [contribuyentes](https://github.com/your/project/contributors) quíenes han participado en este proyecto. 

## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles

## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invita una cerveza 🍺 o un café ☕ a alguien del equipo. 
* Da las gracias públicamente 🤓.
* Dona con cripto a esta dirección: `0xf253fc233333078436d111175e5a76a649890000`
* etc.



---
⌨️ con ❤️ por [Villanuevand](https://github.com/Villanuevand) 😊





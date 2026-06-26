ModelToys
proyecto ModelToys

Error 1: Microservicio de ventas no prendia y tiraba error de conexion, al darle play a ms-ventas, la consola me arrojaba problemas de conexion con la base de datos, la cual lo solucione momentaneamente con cambiar el properties y su ruta a laragon, RECORDAR, MOMENTANEAMENTE.

Error 2: Conflicto con Swagger y HATEOAS al estar juntos.
        - El proyecto falla en el arranque con un error gigante que menciona algo de "modelConverterRegistrar" y "UnsatisfiedDependencyException"}
        - Viendo el error mas a fondo nos dimos cuenta que la libreria de Swagger y la de HATEOAS chocan entre si en esta version de spring boot, porque las dos quieren formatear el JSON al mismo tiempo
        - La solucion hasta el momento es "PAUSAR" HATEOAS comentando la dependencia en el pom, para evitar el choque, ARREGLAR PORFAVOR

Error 3: Error con el Datafacker
        - De la misma manera que el HATEOAS, nos arrojaba error con la version del datafacker, la cual se redujo a la 2.2.2, y tambien rara vez, pero dio, daba error con el import como tal.

Solucion de errores: Se corrigieron los errores correspondientes y se adjunto todo al documento previo.

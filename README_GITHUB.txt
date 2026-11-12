COMPILAR AUTOMATICAMENTE CON GITHUB ACTIONS (SIN INSTALAR GRADLE)

1. Entra en https://github.com y crea una cuenta o inicia sesión.
2. Pulsa el + (arriba a la derecha) > New repository.
3. Nombre: VikingKeyCounter. Selecciona Public o Private y pulsa Create repository.
4. En el repositorio, pulsa Add file > Upload files.
5. DESCOMPRIME este ZIP en tu PC. Entra en la carpeta vikingkey.
6. Arrastra TODO lo que hay dentro de esa carpeta (incluida la carpeta oculta .github) a la página de GitHub.
   IMPORTANTE: activa la opción de mostrar archivos ocultos en Windows para incluir .github.
7. Pulsa Commit changes.
8. Abre la pestaña Actions del repositorio. Debe aparecer "Build VikingKeyCounter".
9. Entra en la ejecución más reciente. Espera a que termine con una marca verde.
10. Baja a Artifacts y descarga VikingKeyCounter. Descomprime ese archivo: dentro estará VikingKeyCounter-1.0.0.jar.
11. Sube el JAR a la carpeta /plugins de tu servidor y reinicia.
12. Prueba: /papi parse me %vikingkey_count%

Si la compilación falla, abre la ejecución de Actions, copia el primer bloque rojo del error y envíamelo.

NOTA: Este proceso compila el código; no garantiza por sí solo que la lectura de los datos internos de ExcellentCrates funcione en runtime. Hay que probarlo en el servidor y revisar el resultado.

VikingKeyCounter 1.0.0
======================

Proyecto fuente para compilar un plugin de Purpur/Paper 1.21.11.
Requiere Java 21, PlaceholderAPI 2.12.3 y ExcellentCrates 7.2.0.

Placeholder:
  %vikingkey_count%

Cuenta objetos TRIAL_KEY cuyo PersistentDataContainer contiene una clave
cuyo nombre corto es "key.id" y cuyo valor STRING es "llave_vikingo".
Cuenta inventario principal y mano secundaria; no cuenta armadura ni cofres.

COMPILAR:
1. Instala JDK 21 y Gradle 8.10 o superior.
2. Abre una terminal en esta carpeta.
3. Ejecuta: gradle build
4. El JAR se genera en: build/libs/VikingKeyCounter-1.0.0.jar

INSTALAR:
1. Copia el JAR a /plugins.
2. Reinicia el servidor.
3. Prueba: /papi parse me %vikingkey_count%
4. En DecentHolograms usa: TIENES %vikingkey_count% LLAVES

NOTA:
Este proyecto se generó a partir de los datos NBT/PDC compartidos por el
usuario. Compílalo y prueba primero en una copia o con backup del servidor.

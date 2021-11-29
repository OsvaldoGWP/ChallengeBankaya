# ChallengeBankaya

## Instrucciones

### Paso 1

Clonar repo y pararse en la rama develop

### Paso 2

Deberá crear una BD en postgres con los siguientes datos:

    * nombre de bd:    bankaya-challenge
    * usuario:         postgres
    * contraseña:      postgres

> Nota: Si algunos de los datos de arriba difieren, por favor actualizar:
> * application.yml(linea 8-11) y
> * el build.gradle(linea 100-103)

### Paso 3

Una vez parado en el raiz del proyecto abrir una PoweShell y ejutar el siguiente comando:

```
.\gradlew flywayMigrate
```

### Paso 4

Para ejecutar la aplicación ejecute el siguiente comando:

```
.\gradlew clean bootRun
```

### Paso 5

Ahora para probar el servicio soap generado siga las instrucciones de
este [Link SoapUI](https://www.adictosaltrabajo.com/2009/12/28/introduccion-soap-ui/)
 

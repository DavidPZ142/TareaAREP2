# TareaAREP2
Para la tarea usted debe construir una aplicación con la arquitectura propuesta y desplegarla en AWS usando EC2 y Docker.
![image](https://user-images.githubusercontent.com/88835434/159068402-62f1769a-5a64-45c9-9e39-57396d97e98c.png)

## Localmente en docker

Teniendo nuestro Docker file y docker compose vamos a crear nuestras imagenes


```
docker build -tag firstdockertarea
```

```
docker-compose up -d
```

![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/contenedores%20docker.jpg)

Lo probamos localmente en localhost:8087 que fue el puerto que se le asigno en docker

![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/correEnDocker.jpg)
![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/correEnDocker1.jpg)


**Luego ya funcionando localmente vamos a subirlo a un nuevo repositorio en dockerHUB**

Esto lo hacemos con el comando:

```
docker push davidpz666/tareaarep2:tagname
```
El tagname se lo asignamos nosotro para identificar es mejor poner tagnames buenos para no confundirnos xd

![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/dockerhub.jpg)

## AWS

**Creamos una instancia EC2**

Creamos su par de llaves
![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/Par%20de%20llaves%20AWS.jpg)

Nos conectamos a la maquina EC2 localmente por el puerto 22 ssh

![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/conectaraws.jpg)

adentro de la maquina vamos a instalar java y docker

```
sudo yum install java-1.8.0
```

```
sudo yum install docker
sudo service docker start
sudo usermod -a -G docker ec2-user
```


Le hacemos pull al dockerhub y ponems a correr el docker

```
docker run -dp 42000:6000
```
abrimos el puerto en la central de nuestro EC2

![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/Reglas%20de%20seguridad.jpg)

y corremos 

![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/correEnAWs.jpg)
![](https://github.com/DavidPZ666/TareaAREP2/blob/master/img/correEnAWS2.jpg)


## Author ✒️
* [David](https://github.com/DavidPZ666)

## Build with 🛠️
* Maven
* Spark
* Docker
* MongoDB

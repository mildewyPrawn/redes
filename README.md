Parte Teórica
=============

Memoria fotográfica
-------------------

##### H3 Edificio
Se decidió utilizar el edificio Poniente (P) de la facultad de Ciencias de la
UNAM.

##### H3 Descripción
El edificio cuenta con 4 pisos que son: Planta Baja, Primer Piso, Segundo Piso y
el Sótano.

**Acometida**  Es la parte de la instalación eléctrica que se construye desde las
redes de distribución, hasta las instalaciones del usuario.

**Cuarto de telecomunicaciones** Área que es utilizada para el uso exclusivo de
equipo asociado  con el sistema de cableado de telecomunicaciones.

**Racks** Racks de cada cuarto (Incluyendo Patch Panels) Estructura que
permite sostener un dispositivo tecnológico. Tenemos en el cuarto de
telecomunicaciones, y en los acces points de cada piso. El diagrama de packet
tracer muestra solo una columna, la configuración del rack, se encuentra abajo.
El diagrama, supone distintos pisos.

**Switches** Switches de acceso, distribución y core. Representan el perímetro
de la red, por dónde entra o sale el tráfico de la red en cuestión.

**Ruteador** Dispositivo empleado a la hora de la interconexión de una red de
ordenadores.

El siguiente diagrama representa al edificio P, con algunas modificaciones para
poder hacer ejemplos más claros.

Los cuadrados chiquitos que engloban computadoras, represenatan salones, y los
rectángulos horizontales, representan los pisos del edificio.

Para las VLAN, se usararon las configuraciones desde el \texttt{CLI} de los
switches.

![alt text](https://github.com/mildewyPrawn/redes/blob/master/rackP.png "Rack")

![alt text](https://github.com/mildewyPrawn/redes/blob/master/nuevoPP.png "Diagrama")

Inventario
----------

Queremos notar que para el piso de la planta baja, Packet tracer no guardó los 
cambios (Ni si quiera en git) por lo que las direcciones pueden variar.

|Equipo | IPs | Máscara de red | Gateway | VLAN |
| ----- |:---:|:--------------:|:--------| ----:|
Switch10 | -----  | ----- | ----- | 10
Switch11 | -----  | ----- | ----- | 11
Switch12 | -----  | ----- | ----- | 12
PC10A  | 10.10.10.7  | 255.0.0.0 | 10.10.10.4 | 10 
PC10A1 | 10.10.10.17  | 255.0.0.0 | 10.10.10.4 | 10
PC10C  | 10.10.10.38  | 255.0.0.0 | 10.10.10.4 | 10
PC11A  | 168.10.0.14  | 255.255.0.0 | 168.10.0.4 | 11
PC11B  | 168.10.0.9 | 255.255.0.0 | 168.10.0.4 | 11
PC11C  | 168.10.0.13 | 255.255.0.0 | 168.10.0.4 | 11
PC11D  | 168.10.0.20 | 255.255.0.0 | 168.10.0.4 | 11
PC11E  | 168.10.0.18 | 255.255.0.0 | 168.10.0.4 | 11
PC12A  | 192.168.10.9 | 255.255.255.0 | 192.168.10.2 | 12
PC12B  | 192.168.10.15  | 255.255.255.0 | 192.168.10.2 | 12
PC12C  | 192.168.10.32 | 255.255.255.0 | 192.168.10.2 | 12
PC12D  | 192.168.10.11 | 255.255.255.0 | 192.168.10.2 | 12
PC12E  | 192.168.10.24 | 255.255.255.0 | 192.168.10.2 | 12
Laptop10B  | 10.10.10.18 | 255.0.0.0 | 10.10.10.4 | 10
Laptop10B1  | 10.10.10.25 | 255.0.0.0 | 10.10.10.4 | 10
Laptop10C  | 10.10.10.43 | 255.0.0.0 | 10.10.10.4 | 10
    
Tabla de rutas
--------------

|Equipo | IPs | Máscara de red | Gateway | VLAN |
| ----- |:---:|:--------------:|:--------| ----:|
|Router0 | 192.0.2.0/24 | ----- | 10 |
| | 198.51.100.0/24 | ----- |  |
| | 203.0.113.0/24 | ----- |  |

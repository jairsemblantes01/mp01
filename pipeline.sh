#!/bin/bash
# -*- ENCODING: UTF-8 -*-
cd /home/jair/Documentos/m1-git/build/install/mp01
pwd
nohup java -Dserver.port=8080 -cp lib/* com.distribuida.Servidor > /dev/null &
nohup java -Dserver.port=8081 -cp lib/* com.distribuida.Servidor > /dev/null &
nohup java -Dserver.port=8082 -cp lib/* com.distribuida.Servidor > /dev/null &
nohup java -Dserver.port=8083 -cp lib/* com.distribuida.Servidor > /dev/null &

echo Ejecutando en segundo plano los servidores en Ubuntu 22.04

exit
#!/bin/bash

CONTAINER="jenkins"
if [ "$(sudo docker inspect --format '{{.State.Status}}' $CONTAINER)" = "running" ]; then
   echo "$(date) - Jenkins está online" >> /home/jenkins/log_Jenkins.log
else
  echo "$(date) - Jenkins está fora do ar. Reiniciando container" >> /home/jenkins/log_Jenkins.log
  sudo docker restart $CONTAINER
  echo "$(date) - Container reiniciado" >> /home/jenkins/log_Jenkins.log
fi
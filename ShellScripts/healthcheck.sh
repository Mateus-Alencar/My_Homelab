#!/bin/bash

CONTAINER="jenkins"
if [ "$(sudo docker inspect --format '{{.State.Status}}' $CONTAINER)" = "running" ]; then
   echo "$(date) - Jenkins está online"
else
  echo "$(date) - Jenkins está fora do ar. Reiniciando container"
  sudo docker restart $CONTAINER
  echo "$(date) - Container reiniciado"
fi
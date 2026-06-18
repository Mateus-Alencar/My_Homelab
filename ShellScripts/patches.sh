#!/bin/bash

if [ "$EUID" -ne 0 ]; then
        echo "Erro: O script deve ser executado com usuário ROOT"
        exit 1
fi      

logger -t "script-updates" -p user.info "Iniciando atualizacao"

echo "Data: $(date '+%Y-%m-%d %H:%M:%S') de atualização"
# Instalando patches e atualizações de seguranca
apt-get upgrade -y
apt-get dist-upgrade -y
# Removendo pacotes desnecessários
apt-get autoremove -y
apt-get clean

logger -t "script-updates" -p user.info "Atualizacao concluida"
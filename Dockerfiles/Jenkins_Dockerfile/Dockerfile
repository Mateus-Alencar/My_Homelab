# Imagem oficial do Jenkins
FROM jenkins/jenkins:lts

# Muda para root para instalar pacotes de sistema
USER root

# Atualiza os repositórios e instala o Ansible
RUN apt-get update && \
    apt-get install -y ansible && \
    # Limpa o cache do apt para reduzir o tamanho da imagem
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Cria o diretório onde os playbooks serão mapeados
RUN mkdir /ansible && chown jenkins:jenkins /ansible

# Volta para o usuário jenkins por segurança
USER jenkins

## Instalação do Minikube

### Requisitos  
- Docker instalado na instância  
- 3 GB de RAM livres para um melhor desempenho  

### Procedimento  
1. Baixar e instalar o Minikube:
```bash
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
```

2. Verificar instalação:
```bash
minikube version
```

3. Iniciar o cluster  
```bash
minikube start --driver=docker
```

4. Verificar o status
```bash
minikube status
```

4. Usar o `kubectl` no cluster
```bash
alias kubectl="minikube kubectl --"
kubectl get nodes
```

4. Comandos para parar e deletar o cluster:
```bash
minikube stop      # pausa o cluster
minikube delete    # remove tudo
```
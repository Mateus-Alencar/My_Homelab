# Provisionamento de Kubernetes com Ansible + Jenkins

Automatizando a instalação de um cluster Kubernetes (1 master + 1 worker) usando Ansible, integrado a uma pipeline no Jenkins.  

## Preparação das máquinas

- Atualizar sistema: `sudo apt update && sudo apt upgrade -y`
- Desabilitar swap:
    ```bash
    sudo swapoff -a
    sudo nano /etc/fstab
    # comentar linha swap
    ```  
- Configurar grupos de hosts no ansible: `sudo vim /home/jenkins/playbooks_ansible/hosts`  
    ```conf
    [targets]
    192.168.100.200
    192.168.100.199

    [workers]
    192.168.100.200

    [master]
    192.168.100.199
    ```
## Passos de execução da playbook ansible

- Instalar Docker
    ```bash
    sudo apt update
    sudo apt install docker.io -y
    sudo systemctl enable docker
    sudo systemctl start docker
    ```
- Instalar dependências do kubernetes
    ```bash
    sudo apt install -y apt-transport-https curl
    curl -fsSL https://pkgs.k8s.io/core:/stable:/v1.29/deb/Release.key | sudo tee /etc/apt/keyrings/kubernetes.asc
    echo "deb [signed-by=/etc/apt/keyrings/kubernetes.asc] https://pkgs.k8s.io/core:/stable:/v1.29/deb/ /" | sudo tee /etc/apt/sources.list.d/kubernetes.list
    ```
- Componentes
    ```bash
    sudo apt update 
    sudo apt install -y kubelet kubeadm kubectl
    sudo apt-mark hold kubelet kubeadm kubectl
    ```

- Preparar Master
    ```bash
    # Inicializar o cluster Kubernetes
    sudo kubeadm init --pod-network-cidr=192.168.0.0/16

    # Configurar acesso ao cluster
    mkdir -p $HOME/.kube
    sudo cp /etc/kubernetes/admin.conf $HOME/.kube/config
    sudo chown $(id -u):$(id -g) $HOME/.kube/config

    # Instalar rede
    kubectl apply -f https://docs.projectcalico.org/manifests/calico.yaml

    # Gerar comando de join
    kubeadm toke create --print-join-command
    ```

- Preparar Worker
    ```bash
    # Executar o comando gerado no master:
    sudo kubeadm join <IP_MASTER>:6443 --token <TOKEN> --discovery-token-ca-cert-hash sha256:<HASH>

    # Validar cluster
    kubectl get nodes
    ```
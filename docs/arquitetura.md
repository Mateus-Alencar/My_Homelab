### Notebook IdeaPad (16 CPU, 16Gb RAM)
- SSH
- GIT
- VM_LENOVO (2 CPU, 2Gb RAM)
    - Docker
      - Grafana
      - Automações Python

> [!NOTE]  
> Grafana vai consumir dados do Zabbix

### Desktop Virtualizador (4 CPU, 16Gb RAM)
- VM_K8s1 (1 CPU, 2Gb RAM)
  - Kubernetes
  - Zabbix proxie
- VM_K8s2 (1 CPU, 2Gb RAM)
  - Kubernetes
  - Zabbix proxie
- VM_K8s3 (1 CPU, 2Gb RAM)
  - Kubernetes
  - Zabbix proxie
- Zabbix proxie

### Notebook LG (2 CPU, 3Gb RAM)
- Jenkins
- Pipelines Ansible
- Zabbix proxie
### Notebook Apple (4 CPU, 8Gb RAM)
>[!NOTE]  
> Ele irá receber: métricas dos proxies, dados do cluster e dados do Jenkins
- Zabbix Server
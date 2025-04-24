helm repo add kubeshark https://helm.kubeshark.co
helm install kubeshark kubeshark/kubeshark
kubectl port-forward service/kubeshark-front 8899:80

# cleanup
#helm uninstall kubeshark
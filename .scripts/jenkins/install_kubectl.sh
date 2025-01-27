#!/bin/bash

# Update the system
echo "Updating the system..."
sudo apt update && sudo apt upgrade -y

# Install necessary dependencies
echo "Installing required dependencies..."
sudo apt-get install -y apt-transport-https ca-certificates curl

# Add Kubernetes APT repository key
echo "Adding Kubernetes APT repository key..."
sudo curl -fsSLo /usr/share/keyrings/kubernetes-archive-keyring.gpg https://packages.cloud.google.com/apt/doc/apt-key.gpg

# Add Kubernetes APT repository
echo "Adding Kubernetes APT repository..."
echo "deb [signed-by=/usr/share/keyrings/kubernetes-archive-keyring.gpg] https://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee /etc/apt/sources.list.d/kubernetes.list > /dev/null

# Update package list
echo "Updating package list..."
sudo apt update

# Install kubectl
echo "Installing kubectl..."
sudo apt install -y kubectl

# Verify installation
echo "Verifying kubectl installation..."
kubectl version --client --output=yaml || { echo "kubectl installation failed!"; exit 1; }

# Enable autocompletion for bash
echo "Setting up kubectl autocompletion for bash..."
sudo apt install -y bash-completion
echo "source <(kubectl completion bash)" >> ~/.bashrc
source ~/.bashrc

# For Zsh users (uncomment if using Zsh)
# echo "Setting up kubectl autocompletion for zsh..."
# echo "source <(kubectl completion zsh)" >> ~/.zshrc
# source ~/.zshrc

echo "kubectl installation and setup completed!"
echo "You can now use kubectl to manage Kubernetes clusters."

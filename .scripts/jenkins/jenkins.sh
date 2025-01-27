#!/bin/bash

# Update the system
echo "Updating the system..."
sudo apt update && sudo apt upgrade -y

# Install Java
echo "Installing Java..."
sudo apt install openjdk-17-jdk -y

# Verify Java installation
java -version || { echo "Java installation failed!"; exit 1; }

# Add Jenkins GPG key and repository
echo "Adding Jenkins repository..."
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key | sudo tee \
/usr/share/keyrings/jenkins-keyring.asc > /dev/null

echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/" | sudo tee \
/etc/apt/sources.list.d/jenkins.list > /dev/null

# Update package list and install Jenkins
echo "Installing Jenkins..."
sudo apt update
sudo apt install jenkins -y

# Start and enable Jenkins service
echo "Starting and enabling Jenkins service..."
sudo systemctl start jenkins
sudo systemctl enable jenkins

# Configure firewall
echo "Configuring firewall..."
sudo ufw allow 8080
sudo ufw --force enable
sudo ufw status

# Display Jenkins initial admin password
echo "Retrieving initial admin password..."
sudo cat /var/lib/jenkins/secrets/initialAdminPassword || { echo "Failed to retrieve admin password!"; exit 1; }

echo "Jenkins installation completed!"
echo "You can access Jenkins at http://<your-server-ip>:8080"

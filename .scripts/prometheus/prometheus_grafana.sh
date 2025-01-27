#!/bin/bash

# Exit script on any error
set -e

# Update and upgrade the system
echo "Updating and upgrading the system..."
sudo apt update && sudo apt upgrade -y

# Install Prometheus
echo "Installing Prometheus..."
PROMETHEUS_VERSION="2.46.0" # Replace with the latest version if needed
wget https://github.com/prometheus/prometheus/releases/download/v${PROMETHEUS_VERSION}/prometheus-${PROMETHEUS_VERSION}.linux-amd64.tar.gz

tar xvf prometheus-${PROMETHEUS_VERSION}.linux-amd64.tar.gz
cd prometheus-${PROMETHEUS_VERSION}.linux-amd64

sudo mv prometheus /usr/local/bin/
sudo mv promtool /usr/local/bin/
sudo mkdir -p /etc/prometheus
sudo mv prometheus.yml /etc/prometheus/

# Create Prometheus service file
echo "Creating Prometheus service file..."
cat <<EOF | sudo tee /etc/systemd/system/prometheus.service
[Unit]
Description=Prometheus
Wants=network-online.target
After=network-online.target

[Service]
User=nobody
ExecStart=/usr/local/bin/prometheus \
  --config.file=/etc/prometheus/prometheus.yml \
  --storage.tsdb.path=/var/lib/prometheus \
  --web.console.templates=/etc/prometheus/consoles \
  --web.console.libraries=/etc/prometheus/console_libraries

[Install]
WantedBy=multi-user.target
EOF

sudo systemctl daemon-reload
sudo systemctl enable prometheus
sudo systemctl start prometheus

echo "Prometheus installed and started successfully."

# Install Grafana
echo "Installing Grafana..."
sudo apt-get install -y software-properties-common
sudo add-apt-repository -y "deb https://packages.grafana.com/oss/deb stable main"
wget -q -O - https://packages.grafana.com/gpg.key | sudo apt-key add -

sudo apt update
sudo apt install grafana -y

sudo systemctl start grafana-server
sudo systemctl enable grafana-server

echo "Grafana installed and started successfully."

# Display completion messages
echo "Installation complete. Access Prometheus at: http://<your-server-ip>:9090"
echo "Access Grafana at: http://<your-server-ip>:3000 (Default login: admin/admin)"

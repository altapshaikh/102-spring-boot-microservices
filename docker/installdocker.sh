#!/bin/bash

# Update the system
echo "Updating the system..."
sudo yum update -y || sudo apt update -y

# Detect the distribution and install Docker accordingly
if [ -f /etc/os-release ]; then
    . /etc/os-release
    DISTRO_NAME=$NAME
    DISTRO_VERSION=$VERSION_ID
fi

# Install Docker based on the detected distribution
if [[ "$DISTRO_NAME" == *"Ubuntu"* ]]; then
    echo "Ubuntu detected. Installing Docker on Ubuntu..."
    
    # Install dependencies
    sudo apt install apt-transport-https ca-certificates curl software-properties-common -y

    # Add Docker's official GPG key
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

    # Add Docker's official repository
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

    # Update the apt package index
    sudo apt update -y

    # Install Docker
    sudo apt install docker-ce docker-ce-cli containerd.io -y

    # Start Docker and enable it to run on boot
    sudo systemctl start docker
    sudo systemctl enable docker
elif [[ "$DISTRO_NAME" == *"Amazon"* ]]; then
    echo "Amazon Linux detected. Installing Docker on Amazon Linux..."

    # Install Docker
    sudo yum install docker -y

    # Start Docker and enable it on boot
    sudo systemctl start docker
    sudo systemctl enable docker
elif [[ "$DISTRO_NAME" == *"CentOS"* ]] || [[ "$DISTRO_NAME" == *"RHEL"* ]]; then
    echo "CentOS/RHEL detected. Installing Docker on CentOS/RHEL..."

    # Install dependencies
    sudo yum install -y yum-utils device-mapper-persistent-data lvm2

    # Set up the Docker repository
    sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo

    # Install Docker
    sudo yum install docker-ce docker-ce-cli containerd.io -y

    # Start Docker and enable it to run on boot
    sudo systemctl start docker
    sudo systemctl enable docker
else
    echo "Unsupported OS. Exiting."
    exit 1
fi

# Add the current user to the Docker group
echo "Adding the current user to the Docker group..."
sudo usermod -aG docker $USER

# Restart Docker service to apply changes
echo "Restarting Docker service..."
sudo systemctl restart docker

# Verify Docker installation
echo "Verifying Docker installation..."
sudo docker --version
sudo docker run hello-world

# Completion message
echo "Docker installation is complete. Log out and log back in to run Docker commands without 'sudo'."

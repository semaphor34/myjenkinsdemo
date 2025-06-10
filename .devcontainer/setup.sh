#!/bin/bash
set -e
if [ -f .env ]; then
    echo 'export $(cat .env | xargs)' >> ~/.bashrc
fi

curl -s https://ngrok-agent.s3.amazonaws.com/ngrok.asc | sudo tee /etc/apt/trusted.gpg.d/ngrok.asc >/dev/null
echo "deb https://ngrok-agent.s3.amazonaws.com buster main" | sudo tee /etc/apt/sources.list.d/ngrok.list
sudo apt update && sudo apt install -y ngrok xz-utils

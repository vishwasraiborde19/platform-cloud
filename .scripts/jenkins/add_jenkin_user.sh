sudo vi /etc/sudoers
jenkins ALL=(ALL) NOPASSWD: ALL # find equivalent copy commnad to update the file via script
sudo su - jenkins


sudo apt install docker.io
sudo usermod -aG docker jenkins
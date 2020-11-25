docker stop $(docker ps -a |grep curso-micros-msc|awk '{print $1;}')
docker rm $(docker ps -a |grep curso-micros-msc|awk '{print $1;}')


docker build --tag curso-micros-msc:v1 .
docker run -itd --network=curso-micros-mysql --name micros-msc -dit --restart always -p 8761:8761 curso-micros-msc:v1

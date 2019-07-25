#README

Docker Configuration

Create network: `docker network create cagdasNetwork
`

Create containers from images that you've built by using `Dockerfile`s:

`docker run -d -p 27017:27017 --network="cagdasNetwork" --name=mongo mongo`
`docker run -d -p 8080:8080 --network="cagdasNetwork" --name=msnote`
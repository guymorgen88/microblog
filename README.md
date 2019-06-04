# Microblog 
# Spring-boot RESTful API & MYSQL with Docker & docker-compose

# General

A simple RESTful JSON API that handle posts resource (create, update, read, etc) 

The Docker compose will create the following containers:

Container|Name
---|---
spring-boot-microblog|spring-boot-microblog
mysql/mysql-server:5.7|mysql-docker-container


# Installation

The following steps will make you run your RESTful JSON API containers.

## Pre requisites

* Docker installed

* Docker compose installed

## Run the docker-compose

1. run docker-compose up inside the project folder in order to create the containers, DB & Tables
The executions is as simple as the following steps:

    ```sh
    docker-compose up
    ```
2. Use Postman (or a similar tool) in order to test the service

## Examples

1. **GET** localhost:8080/post - _get all posts_
2. **POST** http://localhost:8080/post 
    - **Body**: {
                  "title": "test title3",
                  "content": "test content3"
          }
    - _Will add a new post_

3. **GET** http://localhost:8080/post/toppost - _will get top posts_
4. **GET** http://localhost:8080/post/downvote/1 - _downvote postid 1_
5. **GET** http://localhost:8080/post/upvote/2 - _upvote postid 2_
6. **PUT** http://localhost:8080/post/3 
  - **Body**: {
                  "title": "test title3",
                  "content": "test content3"
          }
    - _update postid 3_
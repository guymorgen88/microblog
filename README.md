**Instructions:**

1. run initDb.sh in order to create the DB and Tables 
2. Run server and use Postman (or a similar tool) in order to test the service

_**Examples**_:

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
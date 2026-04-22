일정 관리 API 명세

1. 일정 생성

Method : POST
URL : api/schedules
Request Body : author , title, content
Response Body : id, author, title, content, createdAt, ModifiedAt
Status Code : 201 CREATE

2. 일정 조회 (전체)

Method : GET
URL : api/schedules
Query Parameter : author
Response Body : 일정 배열 (title, content, author, createdAt, ModifiedAt)
Status Code : 200 OK

3. 일정 조회 (선택)

Method : GET
URL : api/schedules/{scheduleID}
Path Variable : scheduleID
Response Body : id, title, content, author, createAt, ModifiedAt
Status Code : 200 OK

4. 일정 수정

Method : PATCH
URL : api/schedules/{scheduleID}
Path Variable : scheduleID
Request Body : title, content, author
Response Body : id, title, content, author, createAT, ModifiedAt
Status Code : 200 OK

5.일정 삭제
Method : DELETE
URL : api/schedules/{scheduleID}
Path Variable : scheduleID
Query Parameter : 
Status Code : 204 No Content

-------------------------------------------

회원 관리 API 명세

1. 회원 생성

Method : POST
URL : api/users
Request Body : username , email
Response Body : id, username, email, createdAt, ModifiedAt
Status Code : 201 CREATE

2. 회원 조회 (전체)

Method : GET
URL : api/users
Query Parameter : username
Response Body : 회원 배열 (id, username, email, createdAt, ModifiedAt)
Status Code : 200 OK

3. 회원 조회 (선택)

Method : GET
URL : api/user/{userID}
Path Variable : userID
Response Body : id, username, email, createAt, ModifiedAt
Status Code : 200 OK

4. 회원 수정

Method : PATCH
URL : api/user/{userID}
Path Variable : userID
Request Body : username, email
Response Body : id, username, email, createAT, ModifiedAt
Status Code : 200 OK

5. 회원 삭제

Method : DELETE
URL : api/user/{userID}
Path Variable : userID
Query Parameter : 
Status Code : 204 No Content

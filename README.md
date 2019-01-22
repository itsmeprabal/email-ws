# email-ws
This is a sample Web Server project for an Email application. Supports limited set of standard operations:

1. Add User
2. Login User
3. Logout User
4. Save Draft
5. Delete Draft 
6. Send Email
7. Delete Email
8. Reply Email
9. Fetch Inbox
10. Fetch unread Inbox
11. Mark Email as Read
12. Fetch Sent
13. Fetch Drafts
14. Fetch Trash 
 
Basic O-auth2 authentication is supported. Fetch APIs are paginated.
 
## Getting Started
 
### Database setup
The application uses MySQL DB and the config can be found in conf/application.conf file.  Ensure the server is running.
It tries to connect to a local MySQL DB running on localhost with user 'root' and password 'root'. Change these values as per your DB config.
Create a database by the name 'play_email' : `create database play_email;`
Grant privileges to the user configured above : 
`grant all privileges on play_email.* to 'user'@'%' identified by 'password';`
`grant all privileges on play_email.* to 'user'@'localhost' identified by 'password';`

### sbt usage
Intall SBT (tested on 1.2.8).
On terminal window, go to the email-ws directory and run : `sbt run`

### Web Service
By default, the WS will run on localhost, port 9000. Connect to http://localhost:9000 on the browser to check (a message Welcome to Play will show)

## API Usage
Following are the APIs (that can be run using Postman or via any other app) and details on how to test them:

1. Create User:
type: PUT request 
url: /users/create
data params: "userEmail", "userName", "userPassword"
remember to add Header with key 'Content-Type' and value 'application/json'

2. Login User:
type: POST request
url: /login
data params: "email", "password"
remember to add Header with key 'Content-Type' and value 'application/json'

The Login API returns a authToken that is to be used for all the authenticated requests like sending emails, saving drafts, fetching inbox, sent etc.

Rest of the APIs can be checked in the file /conf/routes and tested accordingly using Postman or some other application.

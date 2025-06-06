# vlv-eMSP
project name: vlv-eMSP
git address：https://github.com/jiangbw/vlv-eMSP

1、postman script
/vlv-eMSP/script/postman/eMSP-AccountServiceAPI.postman_collection.json
/vlv-eMSP/script/postman/eMSP-CardServiceAPI.postman_collection.json

2、interfaces : request and response
/vlv-eMSP/script/interfaces/CreateAccount.json
/vlv-eMSP/script/interfaces/ChangeAccountStatus.json
/vlv-eMSP/script/interfaces/SearchAccountsbyLastUpdated.json

/vlv-eMSP/script/interfaces/CreateCard.json
/vlv-eMSP/script/interfaces/AssignCard2Account.json
/vlv-eMSP/script/interfaces/ChangeCardStatus.json

3、sql script
src/main/resources/db/schema.sql
4、RDBMS design
src/main/resources/db/EntityRelationshipDiagram.png

5、CI （github）
https://github.com/jiangbw/vlv-eMSP/actions

6、deploy app to AWS
note: 
use Elastic Beanstalk
1、create application
2、create environment -> select web service environment -> set config 
3、get URL Vlv-emsp-app-env.eba-czimup3y.eu-north-1.elasticbeanstalk.com 
4、Manually upload jar to AWS

7、 The problems encountered are:
1. Accessing hub.docker.io requires a proxy
2. Visa card required (create Azure account)
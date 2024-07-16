# Practice System Login-2 (Email consumer)

System Login-2 ทำขึ้นเพื่อศึกษา Spring boot, Restful, Database, Jwt, Kafka, Redis, MVC และการทำงานของระบบ

## Structure Modules

* login (server backend, producer)
* email (consumer)
* common ทำหน้าที่เป็นตัวกลางเพื่อแชร์ข้อมูล email ให้กับ kafka

## Structure email

    └── src/main/java/com/login

        /email
        ├── EmailApplication.java
        |
        ├── config
        |   └── KafkaConfig.java
        |
        ├── listener
        |   └── EmailListener.java
        |
        ├── service
        |   ├── EmailService.java
        |   └── EmailServiceImp.java
        |

    └── src/main

        /resources
            └── application.yml

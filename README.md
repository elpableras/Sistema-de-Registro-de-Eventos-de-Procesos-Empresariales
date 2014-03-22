System-Event-Log-Business-Process
=================================

Degree Project

The project implements a solution for capturing quality records of the business processes in order to centralize the whole process traceability. The shares to record may come from different applications that will serve the information to the Web service built (Registration Server, hereafter SR).

The system (SR) collects information related to the actions of the different phases of the process, which will serve different applications and in turn convert it in records to ensure traceability of the process. Furthermore, all transport of data over the network is performed using: encryption, certification and security firms (both client and server). The data will be stored in a secure database in encrypted form.

Finally, the application will have the option to display the record´s forms stored and may not be modified for anybody. The vision of the records are made ​​through a browser interface, a kind of event viewer.

Programming language:
- JAVA, SQL, XML

Web Server
- Apache Tomcat
- AXIS2
    - Rampart (WS-Security & WS-SecureConversation)
        - Rahas (WS-Trust) 
        - STS (WS-Authorization)
    - Adressing (WS-Adressing)
- Web Services
    - WS-Policy
    - WS-Privacy
    - WS-Security
    - SOAP, WSDL

Cryptography Programs
- Portecle
- OpenSSL

Test Programs
- SOAPUI
- JUnit
- JMeter

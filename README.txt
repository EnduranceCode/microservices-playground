-- Before RUN:
1- Execute micro-serverdb (REQUIRED)
2- Execute micro-cloud-discover (OPTIONAL)
3- Execute micro-cloud-proxy (OPTIONAL)
4- Execute this application as follow: java -jar micro-api-ecommerce.jar --server.port=8086 (change port for each instance you want to run)


-- Analizing Operation

ECOMMERCE INSTANCES (CALL DIRECTLY)
- http://192.168.1.78:8086/swagger-ui.html
- http://192.168.1.78:XXX/swagger-ui.html



-- WITH HAVE RUN 2- 3- (OPTIONALS)

EUREKA 
- http://localhost:8761/

PROXY
- http://localhost:8765/actuator/health


ECOMMERCE INSTANCES (CALL BY PROXY)
- http://localhost:8765/ecommerce/actuator/
- http://localhost:8765/swagger-ui.html




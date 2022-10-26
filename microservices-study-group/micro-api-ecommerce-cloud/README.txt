INSTRUTIONS:

1- Execute above microservices (RUN AS Java Application)

2- H2 Database: Execute micro-server-h2db (REQUIRED)
   - http://localhost:8000/h2-console/ to see H2 Console in action (no password is required)

3- EUREKA: Execute micro-cloud-discover (OPTIONAL)
  - http://localhost:8761/

4- PROXY: Execute micro-cloud-proxy (OPTIONAL)
   - http://localhost:8765/actuator/health

5- Execute micro-api-ecommerce-cloud. (change port on YML file before launch each instance you want to run, or use --server.port=8087 program arguments)

   ECOMMERCE INSTANCES (CALL DIRECTLY)
   - http://localhost:8086/swagger-ui.html to see Swagger with RestControler in action
   - http://localhost:8086/api/orders to see Orders API in action

   ECOMMERCE INSTANCES (CALL BY PROXY)
   - http://localhost:8765/ecommerce/swagger-ui.html
   - http://localhost:8765/ecommerce/api/orders

6- Execute micro-api-finance (change port on YML file before launch each instance you want to run, or use --server.port=8051 program arguments)

7- import src/main/resource/extras/apiEcommerce.postman_collection.json in postman tool (https://www.postman.com/), in order to test easily POST, PUT and DELETE REST operations







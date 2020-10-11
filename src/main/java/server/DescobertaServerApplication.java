
package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DescobertaServerApplication {

    public static void main(String[] args) {

        new SpringApplication(DescobertaServerApplication.class).run(args);
    }

}

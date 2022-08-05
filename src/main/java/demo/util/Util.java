package demo.util;


import java.time.LocalTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component 
public class Util {
	

	@Autowired
	private ServletWebServerApplicationContext webServerAppCtxt;
	
    @Autowired
    private Environment environment;
	
    
    @PostConstruct
    public void init() {
    	
    	LocalTime currentTime = LocalTime.now();
    	System.out.println(currentTime.toString() + " ########## INITIALIZATION DONE ########## ");
    	System.out.println(currentTime.toString() + " ########## " + webServerAppCtxt.getId() + ":" + environment.getProperty("server.port") + " ##########");    	
		System.out.println(currentTime.toString() + " ########## try: localhost:" + environment.getProperty("server.port") + "/h2-console ##########");
    }


}


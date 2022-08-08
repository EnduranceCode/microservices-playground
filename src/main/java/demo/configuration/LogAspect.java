package demo.configuration;

import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	
	
	@Autowired
	private ServletWebServerApplicationContext webServerAppCtxt;
	
	
    @After("within(demo.controler..*)")
    public void restLog(JoinPoint joinPoint) throws Throwable {
    		
		LocalTime currentTime = LocalTime.now();
		System.out.println("########## " + webServerAppCtxt.getId() + ":" +  webServerAppCtxt.getWebServer().getPort() + " " + currentTime.toString()  + " - REQUEST RECEIVED: " + joinPoint.getSignature() + " ##########");	    
    }
	
    
	/*
    @After("@annotation(demo.annotation.LogEnabled)")
    public void restLog(JoinPoint joinPoint) throws Throwable {
    		
		LocalTime currentTime = LocalTime.now();
		System.out.println("########## " + webServerAppCtxt.getId() + ":" +  webServerAppCtxt.getWebServer().getPort() + " " + currentTime.toString()  + " - REQUEST RECEIVED: " + joinPoint.getSignature() + " ##########");	    
    }
    */
	

    /*
    @Around(value = "@annotation(demo.annotation.LogEnabled)")    
    public Object restLogAraound(ProceedingJoinPoint joinPoint) throws Throwable {
        	
    	long startTime = System.currentTimeMillis();
    	
    	Object proceed = joinPoint.proceed();
    	
		long endTime = System.currentTimeMillis();
		
		long totalTime = endTime - startTime;
				
		System.out.println("##########" + webServerAppCtxt.getId() + ":" +  webServerAppCtxt.getWebServer().getPort() + " " + totalTime  + " - REQUEST RECEIVED: " + joinPoint.getSignature() + " ##########");

	    return proceed;
    }
    */
    
	

	
}

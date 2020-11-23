package org.formation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private EurekaClient discoveryClient;
	
	protected Logger logger = Logger.getLogger(ApplicationTests.class.getName());
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSendMail() {
		
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("NOTIFICATION-SERVICE", false);
	    
		Courriel courriel = new Courriel("david.thibau@gmail.com","Hello","It is just a test !");
		RestTemplate restTemplate = new RestTemplate();
		String notificationUrl
		  = instance.getHomePageUrl() + "sendSimple";
		logger.info("POST URL is " + notificationUrl);
		ResponseEntity<String> response
		  = restTemplate.postForEntity(notificationUrl, courriel, String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(response.getBody(), equalTo("OK"));
		
		instance = discoveryClient.getNextServerFromEureka("NOTIFICATION-SERVICE", false);
		notificationUrl
		  = instance.getHomePageUrl() + "sendSimple";
		logger.info("POST URL is " + notificationUrl);
		response
		  = restTemplate.postForEntity(notificationUrl, courriel, String.class);

		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

	}
}

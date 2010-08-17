package spring.registerInstance;

import org.springframework.beans.factory.annotation.Autowired;

public class Client {

	@Autowired Service service;
	
	public String process() {
		return "Client: " + service.getMessage();
	}
}

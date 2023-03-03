package atom.juice.apicompras.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/alive")
public class Alive {

	@GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String hello() {

		return "Hi! The service is alive, everything is running as expected";

	}

}

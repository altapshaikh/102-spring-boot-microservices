package com.ait.resource;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.DTO.Employee;
import com.ait.service.JAXBService;

import jakarta.xml.bind.JAXBException;

@RestController
public class EmployeeController {
	@Autowired
	JAXBService jaxbService;

	@GetMapping(value = "/emp/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return new Employee(id, "raja", 34567d, Arrays.asList("java", "spring boot", "REST"));
	}

	@PostMapping(value = "create", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public Employee createEmployee(@RequestBody Employee emp) {
		emp.setId(1234);
		System.out.println(emp);

		return emp;
	}

	@GetMapping(value = "/marshalling", produces = MediaType.APPLICATION_XML_VALUE)
	public String marshal() throws JAXBException {
		Employee employee = new Employee(1001, "raja", 34567d, Arrays.asList("java", "spring boot", "REST"));
		String marshal = jaxbService.marshal(employee);
		return marshal;
	}

	@GetMapping(value = "/unmarshalling")
	public Employee unmarshal() throws JAXBException {
		String xml = "<employee>\r\n" + "<id>1001</id>\r\n" + "<name>raja</name>\r\n" + "<salary>34567.0</salary>\r\n"
				+ "<skills>\r\n" + "<skill>java</skill>\r\n" + "<skill>spring boot</skill>\r\n"
				+ "<skill>REST</skill>\r\n" + "</skills>\r\n" + "</employee>";
		Employee unmarshal = jaxbService.unmarshal(xml);
		System.out.println(unmarshal);
		return unmarshal;
	}

}

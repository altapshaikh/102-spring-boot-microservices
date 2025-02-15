package com.ait.service;

import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.DTO.Employee;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Service
public class JAXBService {
	

	//marshalling 
	public String marshal(Employee emp) throws JAXBException {
		JAXBContext jaxBInstance  =JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jaxBInstance.createMarshaller();
		//	java--->xml
		StringWriter writer=new StringWriter();
		marshaller.marshal(emp, writer);
		return writer.toString();	
	}
	
	//un-marshalling
	//xml ---->java
	public Employee unmarshal(String xml) throws JAXBException {
		JAXBContext jaxBInstance  =JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxBInstance.createUnmarshaller();
		StringReader reader=new  StringReader(xml);
		Employee unmarshal = (Employee) unmarshaller.unmarshal(reader);
		return unmarshal;
	}
	
	
}

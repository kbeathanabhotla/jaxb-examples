package com.tagcmd.example4;

import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MainClass 
{
	public static void main(String[] args) throws Exception
	{
		JAXBContext jc = JAXBContext.newInstance(DomainObject.class);
		Unmarshaller u = jc.createUnmarshaller();
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		DomainObject listDomain = new DomainObject();
		
		listDomain.items.add(1);
		listDomain.items.add(1.0020f);
		listDomain.items.add(1.65454565);
		listDomain.items.add("Sample text here");
		
		StringWriter stringWriter = new StringWriter();
		
		m.marshal(listDomain, new BufferedWriter(stringWriter));
		
		System.out.println(stringWriter.toString());
		
		DomainObject obj = (DomainObject)u.unmarshal(new StringReader(stringWriter.toString()));
		
		System.out.println(obj);
	}
}

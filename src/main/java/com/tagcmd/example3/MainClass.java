package com.tagcmd.example3;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MainClass 
{
	public static void main(String[] args) throws Exception 
	{
		JAXBContext jc = JAXBContext.newInstance(ListDomain.class);
		Unmarshaller u = jc.createUnmarshaller();
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		String content = "<list>"
							+"<data>D1</data>"
							+"<data>D2</data>"
							+"<data>D3</data>"
							+"<data>D4</data>"
						+"</list>";
		
		ListDomain listDomain = (ListDomain) u.unmarshal(new StringReader(content));
		
		System.out.println(listDomain.toString());
		
		List<String> data = new ArrayList<String>(); 
		data.add("A1");
		data.add("A2");
		data.add("A3");
		data.add("A4");
		
		listDomain.setData(data);
		
		m.marshal(listDomain, System.out);
	}
}

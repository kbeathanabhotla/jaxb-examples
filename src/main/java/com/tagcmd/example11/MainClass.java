package com.tagcmd.example11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		final JAXBContext context = JAXBContext.newInstance(Container.class);
	    final Unmarshaller um = context.createUnmarshaller();
	    Reader reader = null;
	    try {
	        reader = new BufferedReader(new FileReader("partial-input.xml"));
	        QName qName = new QName("rawdata");
	        XMLInputFactory xif = XMLInputFactory.newInstance();
	        XMLEventReader xmlEventReader = xif.createXMLEventReader(reader);
	        Container example = (Container) um.unmarshal(new PartialXmlEventReader(xmlEventReader, qName));
	        //Container example = (Container) um.unmarshal(new FileInputStream("partial-input.xml"));
	        System.out.println(example);
	        
	    } finally {
	       reader.close();
	    }
		
	}

}

package com.tagcmd.example5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

public class MainClass 
{
	public static void main(String[] args) throws Exception
	{
		JAXBContext context = JAXBContext.newInstance();
		
        QName fooQName = new QName("foo");
        JAXBElement<String> e = new JAXBElement<String>(fooQName, String.class, "\n quote\t:\t\" \n amp\t:\t&  \n apos\t:\t'\n");
        
        // set up a normal marshaller
        Marshaller marshaller = context.createMarshaller();
        
        // set up a marshaller with a custom character encoding handler
        marshaller = context.createMarshaller();
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        marshaller.setProperty(CharacterEscapeHandler.class.getName(),new CustomCharacterEscapeHandler());
        
        // check out the console output
        marshaller.marshal( e, System.out );
	}
}

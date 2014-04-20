package com.tagcmd.example7;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MainClass {
    public static void main(String[] args) throws JAXBException {
        // let's create an obvious cycle
    	Person p = new Person();
        p.id = 5;
        p.name = "Joe Chin";
        p.parent = p;
        
        Person p1 = new Person();
        p1.id = 7;
        p1.name = "Mary Gibson";
        p1.parent = p;
        
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        m.marshal(p,System.out);
        System.out.println("\n\n");
        m.marshal(p1,System.out);
    }
}

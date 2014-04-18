package com.tagcmd.example2;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MainClass
{
	public static void main(String[] args) throws Exception
	{
		JAXBContext jc = JAXBContext.newInstance(KitchenWorldBasket.class);
		Unmarshaller u = jc.createUnmarshaller();
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		String content = "<kitchenWorldBasket>"
							+"<basket>"
								+"<entry key=\"9027\">glasstop stove in black</entry>"
								+"<entry key=\"10424\">backsplash kit in black</entry>"
								+"<entry key=\"288\">wooden spoon</entry>"
								+"<entry key=\"289\">salt and pepper shakers in yellow</entry>"
							+"</basket>"
						+"</kitchenWorldBasket>";
		
		KitchenWorldBasket kwBasket = (KitchenWorldBasket) u.unmarshal(new StringReader(content));

		// Demonstrate adapter's unmarshal integrated data into HashMap
		// properly
		System.out.println(kwBasket.toString());

		// Demonstate adapter's marshal writes the data properly
		m.marshal(kwBasket, System.out);
		
	}
}

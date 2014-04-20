package com.tagcmd.example8;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/*
 * $Id: Main.java,v 1.1 2007-12-05 00:49:25 kohsuke Exp $
 */
 
public class Main {
    
    // This sample application demonstrates how to modify a java content
    // tree and marshal it back to a xml data. This example demonstrates
    // customiation within the schema file, po.xsd, and the impact that these 
    // customizations have on the schema derived Java representation.
    
    public static void main( String[] args ) {
        try {
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance( "com.tagcmd.example8" );
            
            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            
            // unmarshal a po instance document into a tree of Java content
            // objects composed of classes from the primer.myPo package.
            JAXBElement poe = 
                (JAXBElement)u.unmarshal( new FileInputStream( "po.xml" ) );
	    POType po = (POType)poe.getValue();

            // change the billto address
            USAddress address = po.getBillTo();
            address.setToName( "John Bob" );
            address.setStreet( "242 Main Street" );
            address.setCity( "Beverly Hills" );
            address.setState(USState.CA);
            address.setZipCode( 90210);
	
            USState purchaseState = address.getState();
            ListIterator iter = po.getItems().getItem().listIterator();
	    while( iter.hasNext()) {
		
                // update to 20% off sale price	
                Items.Item item = (Items.Item)iter.next();
            	item.setPrice(item.getPrice().multiply(new BigDecimal("0.80")));
                
                //Calculate sales tax for specific states
                if (purchaseState == USState.MA) {
                    item.setPrice(item.getPrice().multiply(new BigDecimal("1.05")));
                } else if (purchaseState == USState.CA) {
                    item.setPrice(item.getPrice().multiply(new BigDecimal("1.06")));
                }
                item.setPrice(item.getPrice().setScale(2, BigDecimal.ROUND_DOWN));
            }

            // create a Marshaller and marshal to a file
            Marshaller m = jc.createMarshaller();
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            m.marshal( poe, System.out );
            
        } catch( JAXBException je ) {
            je.printStackTrace();
        } catch( IOException ioe ) {
            ioe.printStackTrace();
        }
    }
}

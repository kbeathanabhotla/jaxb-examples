package com.tagcmd.example10;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {
    public static void main(String[] args) throws Exception {

        // Demonstates shipping and billing data printed in the property
        // order defined by the propOrder annotation element in class 
        // USAddress.        
        JAXBContext jc = JAXBContext.newInstance(PurchaseOrderType.class);
        Unmarshaller u = jc.createUnmarshaller();
        try {
            PurchaseOrderType poType = (PurchaseOrderType)u.unmarshal(new
            File("testData.xml"));
            System.out.println(poType.toString());
        } catch(javax.xml.bind.UnmarshalException e){
            System.out.println("Main: " + e);
        }    
    }
}


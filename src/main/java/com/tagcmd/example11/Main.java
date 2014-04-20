package com.tagcmd.example11;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

/*
 * @(#)$Id: Main.java,v 1.1 2007-12-05 00:49:34 kohsuke Exp $
 */

public class Main {
    public static void main( String[] args ) throws Exception {
        
        // create JAXBContext for the primer.xsd
        JAXBContext context = JAXBContext.newInstance("com.tagcmd.example11");
        
        // create a new XML parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XMLReader reader = factory.newSAXParser().getXMLReader();
        
        // prepare a Splitter
        Splitter splitter = new Splitter(context);
        
        // connect two components
        reader.setContentHandler(splitter);
        
       // for( int i=0; i<args.length; i++ ) {
            // parse all the documents specified via the command line.
            // note that XMLReader expects an URL, not a file name.
            // so we need conversion.
            reader.parse(new File("test.xml").toURL().toExternalForm());
       // }
    }

}

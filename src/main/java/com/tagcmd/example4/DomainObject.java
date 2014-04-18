package com.tagcmd.example4;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="domainObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class DomainObject 
{
	@XmlElementWrapper(name="numbers")
    @XmlElements({
        @XmlElement(name="integer", type=Integer.class),
        @XmlElement(name="float", type=Float.class),
        @XmlElement(name="double", type=Double.class),
        @XmlElement(name="string", type=String.class)
    })
    public List<Object> items = new ArrayList<Object>();
	
	@Override
	public String toString() 
	{
		return this.items.toString();
	}
}

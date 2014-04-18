package com.tagcmd.example3;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="list")
public class ListDomain
{
	private List<String> data = new ArrayList<String>();

	/**
	 * @return the data
	 */
	@XmlElement
	@XmlList
	public List<String> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<String> data)
	{
		this.data.addAll(data);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return data.toString();
	}
}

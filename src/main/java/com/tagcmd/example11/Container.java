package com.tagcmd.example11;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Container {
	
	private String property;
	private String summary;
	@XmlElementWrapper(name="rawdata")
	@XmlElement(name="document")
	private List<Document> rawdata;
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<Document> getRawdata() {
		return rawdata;
	}
	public void setRawdata(List<Document> rawdata) {
		this.rawdata = rawdata;
	}
	@Override
	public String toString() {
		return "Container [property=" + property + ", summary=" + summary + ", rawdata=" + rawdata + "]";
	}
}

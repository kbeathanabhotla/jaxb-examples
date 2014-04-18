package com.tagcmd.example2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class PartEntry {
  @XmlValue public String value;
  @XmlAttribute public int key;
  
  public PartEntry(){}
  public PartEntry(int tKey, String tValue){
    key = tKey;
    value = tValue;
  }
  public String toString(){
    return "key=" + key +"  value=" + value;
  }
}
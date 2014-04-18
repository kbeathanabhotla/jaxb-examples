package com.tagcmd.example2;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/*
 *
 *  PurchaseList - ValueType
 *  HashMap - BoundType
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class AdapterPurchaseListToHashMap extends XmlAdapter<PurchaseList, HashMap> {
    public AdapterPurchaseListToHashMap(){}
    
    // Convert a value type to a bound type.
    // read xml content and put into Java class.
    public HashMap unmarshal(PurchaseList v){        
       HashMap aHashMap = new HashMap();
       int cnt = v.entry.size();
       for(int i=0; i < cnt; i++){
            PartEntry tmpE = (PartEntry)v.entry.get(i);
            aHashMap.put(new Integer(tmpE.key), tmpE.value);
        } 
       return aHashMap;
    }
    
    // Convert a bound type to a value type.
    // write Java content into class that generates desired XML 
    public PurchaseList marshal(HashMap v){
        PurchaseList pList = new PurchaseList();
        // For QA consistency order the output. 
        TreeMap tMap = new TreeMap(v);
        for(Iterator i=tMap.keySet().iterator(); i.hasNext();){
            Integer tmpI = (Integer)i.next();
            pList.entry.add(new PartEntry(tmpI.intValue(), (String)tMap.get(tmpI)));
        }
        return pList;
    }
}
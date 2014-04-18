package com.tagcmd.example6;

import java.io.File;

public class MainClass 
{
	public static void main(String[] args) throws Exception
	{
		File f = new File("input.xml");
		Container c = Container.load(f);
		System.out.println(c.get("foo"));
	}
}

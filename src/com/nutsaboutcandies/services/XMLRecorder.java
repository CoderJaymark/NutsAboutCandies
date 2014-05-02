package com.nutsaboutcandies.services;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class XMLRecorder {
	public static void save(Inventory inv) {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream("c:\\nac\\Inventory.xml")));
			encoder.writeObject("asdasd");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Inventory retrieve() {
		XMLDecoder decoder = null;
//		File file = new File("c:\\nac\\Inventory.xml");
//		if(!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		try {
			decoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream("c:\\nac\\Inventory.xml")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			decoder.close();
		}
		Inventory inv = null;
		try{
		inv = (Inventory) decoder.readObject();
		} catch (ArrayIndexOutOfBoundsException e) {
			inv = new Inventory();
			return inv;
		}
		if(inv==null) inv = new Inventory();
		return inv;

	}
}

package com.nutsaboutcandies.services;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.nutsaboutcandies.user.Cart;


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
	
	public static void saveCart(Cart cart, String filename) {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream(filename)));
			encoder.writeObject(cart);
			encoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static Cart retrieveCart(String filename) {
		XMLDecoder decoder = null;
		if(!new File(filename).exists()){
			return new Cart();
		}
		try {
			decoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			decoder.close();
		}
		Cart cart = null;
		try{
		cart = (Cart) decoder.readObject();
		} catch (ArrayIndexOutOfBoundsException e) {
			cart = new Cart();
			return cart;
		}
		if(cart==null) cart = new Cart();
		return cart;

	}

	public static Inventory retrieve() {
		XMLDecoder decoder = null;

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

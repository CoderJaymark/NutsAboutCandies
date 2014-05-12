package com.nutsaboutcandies.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class ImageUploader {
	public static void upload(ServletContext context, HttpServletRequest req) {
		
		try {
 	
            // get access to file that is uploaded from client
            Part p1 = req.getPart("fileName");
            InputStream is = p1.getInputStream();

            // read filename which is sent as a part
            Part p2  = req.getPart("hiddenFileName");
            Scanner s = new Scanner(p2.getInputStream());
            String filename = s.nextLine();    // read filename from stream

            // get filename to use on the server
            String outputfile = context.getRealPath("") + File.separator + "uploads" + File.separator + filename;  // get path on the server
            FileOutputStream os = new FileOutputStream (outputfile);
            System.out.println(outputfile);
            // write bytes taken from uploaded file to target file
            int ch = is.read();
            while (ch != -1) {
                 os.write(ch);
                 ch = is.read();
            }
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

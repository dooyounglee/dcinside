package com.kh.dc.gallary;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		int random=(int)(Math.random()*100000);
		
		String name= originFile.getName();
		
		String ext = "";
		
		int dot = name.lastIndexOf(".");
		
		if(dot != -1) {
			ext = name.substring(dot);
		}
		
		String fileName = sdf.format(new Date(currentTime)) + random + ext;
		
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
		
	}
}



package es4;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Base64;

public class Main2 {
	public static void main(String[] args) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			FileInputStream fs = new FileInputStream(
					new File("/media/5agr14/Capoccia/VSCode-win32-x64-1.82.2.zip"));
			FileChannel channel = fs.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int bytes;
			while((bytes = channel.read(buffer)) != -1) {
				md.update(buffer.array(), 0, bytes);
				buffer.clear();
			}
			System.out.println(new BigInteger(1, md.digest()).toString(16));
		} catch (Exception e) {}
	}

}

package esAESfile;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class Cifra {

	static final String INPUTFILENAME = "src" + File.separator + "esAESfile"+ File.separator + "file.txt";
	static final String OUTPUTFILENAME = "src" + File.separator + "esAESfile"+ File.separator + "file.aes";

	public static void main(String[] args) throws Exception {
		SecretKeySpec key = new SecretKeySpec("segreto1segreto1".getBytes(), "AES");
		encryptFIle(key);

	}
	static void encryptFIle(SecretKey key) throws Exception {
		Socket toRizzy = new Socket("10.0.2.89", 60000);
		DataOutputStream out = new DataOutputStream(toRizzy.getOutputStream());
		
		File original = new File(INPUTFILENAME);
		File crypted = new File(OUTPUTFILENAME);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		FileInputStream ifstream = new FileInputStream(original);
		int bytesReadLength = -1;
		byte[] buffer = new byte[64];
		byte[] output;
		FileOutputStream outFile = new FileOutputStream(crypted);
		while((bytesReadLength = ifstream.read(buffer)) != -1) {
			output = cipher.update(buffer, 0, bytesReadLength);
			if(output != null) {
				outFile.write(output);
				out.write(output,0, bytesReadLength);
			}
		}
		output = cipher.doFinal();
		if(output != null) {
			outFile.write(output);
			out.write(output);
		}
		outFile.close();
		out.close();
		toRizzy.close();
	}

}

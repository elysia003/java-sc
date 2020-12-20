package com.ciyo.server.file.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.ciyo.common.unitl.R;
import com.ciyo.server.file.bean.Chunk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

import org.apache.http.HttpStatus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;

@RestController
public class UploadController {
	@PostMapping(value = "/upload")
	public String upload(Chunk chunk) {
		System.out.println(chunk.getFile());
		MultipartFile file = chunk.getFile();
		String name = chunk.getIdentifier();
		int chunk_num = chunk.getChunkNumber();
		String base_path = "C:\\Users\\11373\\test";
		File serverFile = new File(base_path + "\\" + name + "_" + chunk_num);
		try {
			file.transferTo(serverFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chunk.toString();
	}

	@GetMapping(value = "/upload")
	public ResponseEntity<String> check(Chunk chunk) {
		System.out.println("Get____>>>" + chunk);
		boolean find = false;
		if (!find) {
			return ResponseEntity.status(204).body("{\"msg\": \"文件块不存在，可传\"}");
		} else {
			return ResponseEntity.status(200).body("{\"msg\": \"文件块已上传，无须再传\"}");
		}
	}

	@GetMapping(value = "/hs")
	public Callable<String> createOrder(Chunk chunk,String username) {
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				MessageDigest messageDigest=null;
		        try {
					messageDigest =MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println("UUUUUUU"+chunk);
				String name = chunk.getIdentifier() + ".fin";
				String base_path = "C:\\Users\\11373\\test";
				File newFile = new File(base_path + "\\" + name);
				byte[] byt = new byte[100 * 1024 * 1024];
				int len;
				FileOutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(newFile, true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileInputStream fileInputStream = null;
				try {
					for (int i = 1; i < chunk.getTotalChunks(); i++) {
						fileInputStream = new FileInputStream(new File(base_path + "\\" + chunk.getIdentifier() + "_" + i));
						len = fileInputStream.read(byt);
						while (len != -1) {
							messageDigest.update(byt, 0, len);
							outputStream.write(byt, 0, len);
							len = fileInputStream.read(byt);
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fileInputStream.close();
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.gc();
				byte[] bytes=messageDigest.digest();
		        StringBuffer sb = new StringBuffer();  
		        for (int i = 0; i < bytes.length; i++) {  
		            byte b = bytes[i];  
		            if ((b & 0xff) < 0xf) {  
		                sb.append("0");  
		            }  
		            sb.append(Integer.toHexString(b & 0xff));  
		        }
				String md5=sb.toString();
				if(md5.equals(chunk.getIdentifier())){
					return "success";
				}
				else {
					return "fail";
				}
			}
		};
		return callable;
	}

	@GetMapping(value = "/merge")
	public String finish(Chunk chunk) {
		MessageDigest messageDigest=null;
        try {
			messageDigest =MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("UUUUUUU"+chunk);
		String name = chunk.getIdentifier() + ".fin";
		String base_path = "C:\\Users\\11373\\test";
		File newFile = new File(base_path + "\\" + name);
		byte[] byt = new byte[100 * 1024 * 1024];
		int len;
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(newFile, true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileInputStream fileInputStream = null;
		try {
			for (int i = 1; i < chunk.getTotalChunks(); i++) {
				fileInputStream = new FileInputStream(new File(base_path + "\\" + chunk.getIdentifier() + "_" + i));
				len = fileInputStream.read(byt);
				while (len != -1) {
					messageDigest.update(byt, 0, len);
					outputStream.write(byt, 0, len);
					len = fileInputStream.read(byt);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.gc();
		byte[] bytes=messageDigest.digest();
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < bytes.length; i++) {  
            byte b = bytes[i];  
            if ((b & 0xff) < 0xf) {  
                sb.append("0");  
            }  
            sb.append(Integer.toHexString(b & 0xff));  
        }
		return sb.toString();
	}
}

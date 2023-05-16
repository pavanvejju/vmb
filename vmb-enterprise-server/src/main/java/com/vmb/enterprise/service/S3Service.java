package com.vmb.enterprise.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
@Service
public class S3Service {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${bucketName:lc-data-storage}")
	private String bucketName;
	
//	@Value("${keyName:test2.txt}")
//	private String keyName;
	
//	@Value("${folderName:table_video_stream/01-02-2023}")
//	private String folderName;
	
//	@Value("${filePath:/tmp/text1.txt}")
//	private String filePath;
	

public void uploadVideos(String folderName, File baseObj) throws IOException{    
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new InstanceProfileCredentialsProvider(false)).build();
		
//		readDataFromFile(s3Client, keyName);
		createFolder(s3Client, bucketName, folderName);
		//uploadBaseObject(s3Client, bucketName, folderName, baseObj);
		uploadFileObject(s3Client, bucketName, folderName, baseObj);
	//	uploadFile(s3Client, bucketName, folderName, filePath);
	}

	
	public void createFolder(AmazonS3 client, String bucketName, String folderName) {
	    // create meta-data for your folder and set content-length to 0
	    ObjectMetadata metadata = new ObjectMetadata();
	    metadata.setContentLength(0);
	    // create empty content
	    InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
	    // create a PutObjectRequest passing the folder name suffixed by /
	    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName, emptyContent, metadata);
	    // send request to S3 to create folder
	    client.putObject(putObjectRequest);
	}
	private void readDataFromFile(AmazonS3 s3Client, String keyName) {
		try {
			logger.info("Downloading an object");
			S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, keyName));
			try {
				displayTextInputStream(s3object.getObjectContent());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AmazonServiceException ase) {
			System.err.println("Exception was thrown by the service");
		} catch (AmazonClientException ace) {
			System.err.println("Exception was thrown by the client");
		}
	}
	
	private void uploadFileObject(AmazonS3 s3Client, String bucketName, String folderName, File fileObject) {
		try {
            logger.info("UPLOAD files to S3:::::"+folderName+":::"+fileObject);
            
           
			PutObjectResult  pRes = s3Client.putObject(bucketName, folderName, fileObject);
			
		} catch (AmazonServiceException e) {
		    System.err.println("upload to s3>>>>>>>>>>>>>"+e.getErrorMessage());
		}
	}
	
	private void uploadBaseObject(AmazonS3 s3Client, String bucketName, String folderName, byte[] base64Object) {
		try {
            logger.info("UPLOAD files to S3:::::"+folderName+":::"+base64Object);
            
            ObjectMetadata metadata = new ObjectMetadata();
    	   // metadata.setContentLength(base64Object.length);
    	    InputStream content = new ByteArrayInputStream(base64Object);
			PutObjectResult  pRes = s3Client.putObject(bucketName, folderName, content,metadata);
			
		} catch (AmazonServiceException e) {
		    System.err.println("upload to s3>>>>>>>>>>>>>"+e.getErrorMessage());
		}
	}
	
	private void uploadFile(AmazonS3 s3Client, String bucketName, String folderName, String filePath) {
		try {
            logger.info("UPLOAD files to S3:::::"+folderName+":::"+filePath);
			PutObjectResult  pRes = s3Client.putObject(bucketName, folderName, new File(filePath));
		} catch (AmazonServiceException e) {
		    System.err.println("upload to s3>>>>>>>>>>>>>"+e.getErrorMessage());
		}
	}
	
	private void displayTextInputStream(InputStream input) throws IOException {
		// Read one text line at a time and display.
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		logger.info("=====================================================");
		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			logger.info("    " + line);
		}
		logger.info("=====================================================");
	}
}


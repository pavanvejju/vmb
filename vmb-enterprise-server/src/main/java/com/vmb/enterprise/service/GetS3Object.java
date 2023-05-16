package com.vmb.enterprise.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class GetS3Object {
	private static final String bucketName = "arn:aws:s3:eu-west-1:726822028714:accesspoint/*";
	
	  private static final String key = "lc-data-storage";

	  public static void main(String[] args) throws IOException
	  {
	    AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

	    try {
	      System.out.println("Downloading an object");
	      S3Object s3object = s3Client.getObject(
	          new GetObjectRequest(bucketName, key));
	      displayTextInputStream(s3object.getObjectContent());
	    }
	    catch(AmazonServiceException ase) {
	      System.err.println("Exception was thrown by the service");
	    }
	    catch(AmazonClientException ace) {
	      System.err.println("Exception was thrown by the client");
	    }
	  }

	  private static void displayTextInputStream(InputStream input) throws IOException
	  {
	    // Read one text line at a time and display.
	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    while(true)
	    {
	      String line = reader.readLine();
	      if(line == null) break;
	      System.out.println( "    " + line );
	    }
	    System.out.println();
	  }
}

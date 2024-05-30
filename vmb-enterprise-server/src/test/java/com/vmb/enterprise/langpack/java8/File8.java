package com.vmb.enterprise.langpack.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class File8 {

	public static void main(String[] args) throws IOException, InterruptedException {

		String content	=	"Test Class execution";
		Files.write(Paths.get("D://Test//output.txt"),content.getBytes(),StandardOpenOption.CREATE );
		//System.out.println(Files.readAllBytes(Paths.get("D://Test//output.txt")));
		
		Path path = Paths.get("D://Test");
		WatchService watchService =  path.getFileSystem().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		
		try{
			WatchKey watchKey = null;
			while (true) {
			    watchKey = watchService.poll(10, TimeUnit.SECONDS);
			    if(watchKey != null) {
			        watchKey.pollEvents().stream().forEach(event -> System.out.println(event.kind().name() +"=="+  event.context()));
				    watchKey.reset();
			    }

			}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

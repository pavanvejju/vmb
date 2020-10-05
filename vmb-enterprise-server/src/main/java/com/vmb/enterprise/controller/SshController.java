package com.vmb.enterprise.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmb.enterprise.dto.SSHRequestDto;
import com.vmb.enterprise.utils.SshUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/ssh")
public class SshController {

	
	@PostMapping("/connect")
	public String createCustomer(@RequestBody SSHRequestDto sshRequestDto) {
		String result	=	"";
		try {
			result	=	SshUtil.listFolderStructure(sshRequestDto.getKey(),sshRequestDto.getUserName(), sshRequestDto.getPassword(), sshRequestDto.getHost(), sshRequestDto.getPort(), sshRequestDto.getCommand());
			System.out.println("result::"+result);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

}

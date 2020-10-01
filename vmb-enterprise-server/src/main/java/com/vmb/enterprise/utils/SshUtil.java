package com.vmb.enterprise.utils;

import java.io.ByteArrayOutputStream;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshUtil {

	private static String key="-----BEGIN RSA PRIVATE KEY-----\n" + 
			"MIIEogIBAAKCAQEAsLYLt0pGlzJaS6Y6M7/hkqL2pPsKZYa8eMP2lo41Irk3StxOkPmQkyjHxG+n\n" + 
			"LlkTQB77Bf79wKx7G2/2KCOHCutrVt2KLVaE8OboJqR2PgMSvmROqdQXfpmrPySggCV/f7Bk6P2e\n" + 
			"q+6a9e7zjzwDPJP+JtM3/PSza9t7XfDYWQ0Vp26tTwhL2iwDWB3JRABKmFAgDg7WJIEBlvz/Q6AV\n" + 
			"AWRVTTNZqtO3KOqD4ynCoumU69OPdZH119JMZUuYZGiC/AAy6v/KircEQ2LLBeXUEI0cD7w/Gj3N\n" + 
			"a9glheHHTzUrKpptGkR/kkzLeT3uOERBcyDoejWIa0TFmgDMeelW0wIDAQABAoIBACp72d07EjWP\n" + 
			"eX3ufNesLgMfAsUvRZSbC/zMwB/6GHQ8qzpoNMtN9KAskbp8TWkrKSGlURxj7YXA8efqxvdnczQA\n" + 
			"3VGI+Ytk3Zk9Klr/9x15h6wWWYMi5nMdZrpLh/rHCRwdwGTzdI5JUyAFTrEE8JJD0jprVW6PNgOc\n" + 
			"RNCU8q6VuxfeaG2uQ7Aq+gfcOYBP1EmLP5lrHUEjPoc/3nnO3FWw1TXpWzq+lSAs/C5Xj0Bnv0N7\n" + 
			"0wvr956T+5H7c6OfLw2Q527aUe8XrutFDjZqDY9t4mpFTty6Ko/yYAFn3Web1qfFd4J8YVBezGjU\n" + 
			"CP+id8SaG1YFa5fA6IBTgPOHvOECgYEA+m6dz/Ai0Hyg7qNnN9Pb9wRayR9o8slLsyB77KGyfSPx\n" + 
			"1XY49uyqtk8FWH/Sv9p0r927rEGpwbfLYh1Z5gxAz9GXclb3gN27MD5cZLHOqHbSOy+vmasq6x6d\n" + 
			"a9KecXdkdRddSOd0NgpIrdv1jx7FVwIKa+BM84QrG+oKpNDQWt8CgYEAtKPU9E+lDa+VcZjcPafh\n" + 
			"9ffsF5661jlW+jGjwABnSWlrTZ89LZQU27JIA+Jm18JtwEhXFS9fqiwv0xy9rWuKo0uvckSVshfu\n" + 
			"zBuTy9psPn0klshlqme2iwyc7YBxLGMi0r4ZNobZUwIAqJJKvxjKHsZTYmhffToV9Ebvke/L9o0C\n" + 
			"gYAFs4b8OOdR/8RaKnYrGzOiyAKZGZH2FQcYKOEpXfUGTE8xIOPjGzg3tkzU2vQdUgfeCRpAra4D\n" + 
			"rv9+WFS3nAfNs2PTQo+X63RbgM/xquqdgzb+CfPhd7geajADSGQ7CRDMaZ/CDSLkKA/HhX5tp7Gu\n" + 
			"bWl3Uz/tO1EP7aAYaHiV2QKBgAwUAEMtqB2YJefojqFYvlUR9KlHpbp5LwWfmBFYdY+FCvWvtgl8\n" + 
			"I0DlVMddtf6rM2dt7tStzDm2pqP5Af28eRKeFucPCutTilX/agxxWFd9SpsCXznboWr+tudydR7A\n" + 
			"qi1pJIpuzc0tDxo2XeUVJT6ViDHGRMw8vAcPTyl03TBpAoGAOrHUm5o1exOUzZmt5943ak+71jTa\n" + 
			"Dd63xdF7oyK48arWvooroM4/rnrcC1DjK1QDaItqYnkL2dYfmLuqkqIOy0Lsjd3h2CwB7A77z1aG\n" + 
			"aZV4EE1FrKO+LC1zER0yvVKC/Pci9pubIsQLzkP2IMynv/YemJE1u/YU61mf1g5pqMY=\n" + 
			"-----END RSA PRIVATE KEY-----";
	private static String userName="ubuntu";
	private static String host	=	"ec2-18-185-46-119.eu-central-1.compute.amazonaws.com";
	private static int port	=	22;
	private static String command	=	"ls -lrth";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			listFolderStructure(key,userName,null,host,port);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void listFolderStructure(String key, String username, String password, 
			  String host, int port) throws Exception {
			    
			    Session session = null;
			    ChannelExec channel = null;
			    
			    try {
			    	JSch ssh = new JSch();
					ssh.addIdentity("sampletest", key.getBytes(), null, null);
			        session = ssh.getSession(username, host, port);
			        session.setPassword(password);
			        session.setConfig("StrictHostKeyChecking", "no");
			        
			       
			        session.connect();
			        
			        channel = (ChannelExec) session.openChannel("exec");
			        channel.setCommand(command);
			        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			        channel.setOutputStream(responseStream);
			        channel.connect();
			        
			        while (channel.isConnected()) {
			            Thread.sleep(100);
			        }
			        
			        String responseString = new String(responseStream.toByteArray());
			        System.out.println(responseString);
			    } finally {
			        if (session != null) {
			            session.disconnect();
			        }
			        if (channel != null) {
			            channel.disconnect();
			        }
			    }
			}

}

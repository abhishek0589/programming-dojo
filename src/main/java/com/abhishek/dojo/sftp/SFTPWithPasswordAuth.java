//package com.abhishek.dojo.sftp;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;
//
//public class SFTPWithPasswordAuth {
//
//	public static void main(String[] args) throws FileNotFoundException {
//
//		JschConnectionManager jschConnManager = new JschConnectionManager();
//		Session session = null;
//		ChannelSftp channel = null;
//		InputStream stream = null;
//
//		try {
//
//			session = jschConnManager.getSession();
//			channel = jschConnManager.openSftpChannel(session);
//			channel.cd(jschConnManager.ASSETS_SFTPWORKINGDIR);
//			System.out.println("changed working dir ...");
//			
//			File f1 = new File(SFTPWithPublicKeyAuth.class.getClassLoader().getResource("1496956324.csv").getPath());
//			channel.put(new FileInputStream(f1), f1.getName());
//			System.out.println("file uploaded ...");
//			channel.exit();
//			session.disconnect();
//			
//		} 
//		
//		catch (SftpException e) {
//			e.printStackTrace();
//		}  finally {
//			if (channel != null) {
//				jschConnManager.closeSftpChannel(channel);
//				jschConnManager.closeSession(session);
//			}
//
//		}
//	}
//}

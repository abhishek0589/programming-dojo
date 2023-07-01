//package com.abhishek.dojo.sftp;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;
//import com.jcraft.jsch.UserInfo;
//
//public class SFTPWithPublicKeyAuth {
//
//	/**
//	 * @param args
//	 * @throws FileNotFoundException
//	 */
//	public static void main(String[] args) throws FileNotFoundException {
//		String SFTPHOST = "35.160.232.65";
//		int SFTPPORT = 22;
//		String SFTPUSER = "ge";
//		String privateKey = SFTPWithPublicKeyAuth.class.getClassLoader().getResource("id_rsa").getPath();
//		String SFTPWORKINGDIR = "/home/ge/sftp/";
//
//		JSch jSch = new JSch();
//		Session session = null;
//		Channel channel = null;
//		ChannelSftp channelSftp = null;
//		try {
//			jSch.addIdentity(privateKey);
//			System.out.println("Private Key Added.");
//			session = jSch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
//			System.out.println("session created.");
//			java.util.Properties config = new java.util.Properties();
//			config.put("StrictHostKeyChecking", "no");
//			session.setConfig(config);
//			setUserInfo(session);
//			session.connect();
//			channel = session.openChannel("sftp");
//			channel.connect();
//			System.out.println("shell channel connected....");
//			channelSftp = (ChannelSftp) channel;
//			channelSftp.cd(SFTPWORKINGDIR);
//			System.out.println("Changed the directory...");
//
//			File f1 = new File(SFTPWithPublicKeyAuth.class.getClassLoader().getResource("1496956324.csv").getPath());
//			channelSftp.put(new FileInputStream(f1), f1.getName());
//			System.out.println("file uploaded ...");
//			channelSftp.exit();
//			session.disconnect();
//
//		} catch (JSchException e) {
//			e.printStackTrace();
//		} catch (SftpException e) {
//			e.printStackTrace();
//		} finally {
//			if (channelSftp != null) {
//				channelSftp.disconnect();
//				channelSftp.exit();
//			}
//			if (channel != null)
//				channel.disconnect();
//			if (session != null)
//				session.disconnect();
//		}
//	}
//
//	private static void setUserInfo(Session session) {
//		session.setUserInfo(new UserInfo() {
//			@Override
//			public void showMessage(String arg0) {
//			}
//
//			@Override
//			public boolean promptYesNo(String arg0) {
//				return false;
//			}
//
//			@Override
//			public boolean promptPassword(String arg0) {
//				return false;
//			}
//
//			@Override
//			public boolean promptPassphrase(String arg0) {
//				return true;
//			}
//
//			@Override
//			public String getPassword() {
//				return null;
//			}
//
//			@Override
//			public String getPassphrase() {
//				return "test@123";
//			}
//		});
//	}
//
//}
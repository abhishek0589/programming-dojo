//package com.abhishek.dojo.sftp;
//
//import java.util.ArrayList;
//import java.util.Vector;
//
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;
//
//public class JschConnectionManager {
//
//	private String SFTPHOST = "XX";
//
//	private Integer SFTPPORT = 22;
//
//	private String SFTPUSER = "ge";
//
//	private String SFTPPASS = "G2o!7$3p0*j(4c56";
//
//	public String ASSETS_SFTPWORKINGDIR = "/var/ftp/ge/em-history-data-loader/assets";
//
//	public String SITES_SFTPWORKINGDIR = "/var/ftp/ge/em-history-data-loader/assets";
//
//	public String SEGMENTS_SFTPWORKINGDIR = "/var/ftp/ge/em-history-data-loader/assets";
//
//
//	public Session getSession(){
//		Session session = null;
//		JSch jsch = new JSch();
//		try {
//			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
//			session.setConfig("compression.s2c", "zlib@openssh.com,zlib,none");
//			session.setConfig("compression.c2s", "zlib@openssh.com,zlib,none");
//			session.setPassword(SFTPPASS);
//			java.util.Properties config = new java.util.Properties();
//			config.put("StrictHostKeyChecking", "no");
//			session.setConfig(config);
//			session.connect();
//		} catch (JSchException e) {
//			e.printStackTrace();
//		}
//		return session;
//	}
//
//	public void closeSession(Session session){
//		session.disconnect();
//	}
//
//	public ChannelSftp openSftpChannel(Session session){
//		com.jcraft.jsch.Channel channel = null;
//		ChannelSftp channelSftp = null;
//		try {
//			channel = session.openChannel("sftp");
//			channel.connect();
//			channelSftp = (ChannelSftp) channel;
//		} catch (JSchException e) {
//			e.printStackTrace();
//		}
//		return channelSftp;
//	}
//
//	public void closeSftpChannel(ChannelSftp channel){
//		channel.disconnect();
//	}
//
//	public ArrayList<String> getCSVListFromSftp(String directory){
//
//		ArrayList<String> fileList = new ArrayList<String>();
//		Vector<ChannelSftp.LsEntry> csvs = null;
//
//		Session session = null;
//		ChannelSftp channel = null;
//		try {
//			session = this.getSession();
//			channel = this.openSftpChannel(session);
//			channel.cd(directory);
//			csvs = channel.ls("*.csv");
//			for(ChannelSftp.LsEntry entry : csvs) {
//				fileList.add(entry.getFilename().trim()); 
//			}
//		} catch (SftpException e) {
//			e.printStackTrace();
//		}finally {
//			this.closeSftpChannel(channel);
//			this.closeSession(session);
//		}
//		return fileList;
//	}
//
//}

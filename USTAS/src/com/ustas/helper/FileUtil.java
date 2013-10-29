package com.ustas.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FileUtil {
	
	
	public static File  downloadAttendanceFile(String server,int port,String user,String pass,String path) {
  
        File newFile =null;
        FTPClient ftpClient = new FTPClient(); 
        try {
   
            ftpClient.connect(server,port);
            ftpClient.login(user,pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            FTPFile[] files = ftpClient.listFiles(); 
          //  File dir = new File("D:"+File.separator+"AttendanceProcess"+File.separator+"Unsynchronized");
            File dir = new File(path);
    
            dir.mkdirs();
            String remoteFile ="attendance.txt";
            
        	newFile = new File(dir,"attendance.txt");

            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(newFile));
            boolean success = ftpClient.retrieveFile(remoteFile, outputStream1); 
            outputStream1.close();
         
            if (success) {
                System.out.println("File has been downloaded successfully.");
            }
//            for(FTPFile file:files)
//             {
            	   boolean deleted=ftpClient.deleteFile(remoteFile);  
                   if (deleted) {
                       System.out.println("The file was deleted successfully.");
                   } else {
                       System.out.println("Could not delete the file.");
                   }
//             }
//           boolean deleted=ftpClient.deleteFile(remoteFile);
//            if (deleted) {
//                System.out.println("The file was deleted successfully.");
//            } else {
//                System.out.println("Could not delete the file.");
//            }
            // APPROACH #2: using InputStream retrieveFileStream(String)
//            String remoteFile2 = "/FTPTest/attendance.txt";
//            File dir1 = new File("D:"+File.separator+"AttendanceProcess");
//            dir1.mkdir();
//            File newFile1 = new File(dir,"attendance1.txt");
//            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(newFile1));
//            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
//            byte[] bytesArray = new byte[4096];
//           int bytesRead = -1;
//            while ((bytesRead = inputStream.read(bytesArray)) != -1) { 
//               outputStream2.write(bytesArray, 0, bytesRead);            }
// 
//            success = ftpClient.completePendingCommand();
//            if (success) {
//                System.out.println("File #2 has been downloaded successfully.");
//            }
//            outputStream2.close();
//          inputStream.close();
 
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Fount: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex.getMessage());
            ex.printStackTrace();
        
          } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                 }
                } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return newFile;
    }

}

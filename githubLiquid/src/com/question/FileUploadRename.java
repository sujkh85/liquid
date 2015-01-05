package com.question;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadRename implements FileRenamePolicy {
  
 private String save_file_name;
 public FileUploadRename() {}
 
 public FileUploadRename( String save_file_name){
  this.save_file_name = save_file_name;
 } 
 
 public File rename(File f) {
//  Get the parent directory path as in h:/home/user or /home/user
        String parentDir = f.getParent();
      
        //Get filename without its path location, such as 'index.txt'
        String fname = f.getName();
      
        //Get the extension if the file has one
        String fileExt = "";
        int i = -1;
        if(( i = fname.lastIndexOf(".")) != -1){
      
            fileExt = fname.substring(i); // only file extension
            fname = fname.substring(0,i); // except file extension
        }
      
        //add the timestamp
//        fname = save_file_name;
//        fname = fname +(""+(new Date().getTime() / 1000));
        QnABoardDAO dao = new QnABoardDAO();
        int curBoardNumber = dao.curBoardNumber();
        fname = curBoardNumber+1+"_"+fname ;
      
        //piece together the filename
        fname = parentDir + System.getProperty(//파일 구분 문자(\)
            "file.separator") + fname + fileExt;
        File file = new File(fname);
        return file;

 }

}



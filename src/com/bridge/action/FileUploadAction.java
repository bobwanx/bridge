package com.bridge.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
    private String msg = null;// �û����淵�ؿͻ��˵���Ϣ
    private File myFile[] = null;// �ļ�����
    private String[] myFileContentType = null; // �û��洢�ļ�����
    private String[] myFileFileName = null; // ���ڴ����ļ����ƣ������ļ�����+��չ���ƣ�
    /**
     * �����ļ��ς�
     */
    public String execute() throws Exception {
        String realPath = ServletActionContext.getServletContext() .getRealPath("/");
        for (int i = 0; i < myFile.length; i++) {
            File srcfile = myFile[i];
            if (srcfile != null) {
                FileUtil.writeFileTo(srcfile, realPath + "\\upload\\"
                        + reBuildFileName(myFileFileName[i]));
            }
        }
        setMsg("<script>"+"alert('�ļ��ϴ��ɹ���');"+"</script>");
        return SUCCESS;
    }
    /**
     * ���¹����ļ����ƣ��ļ�����Ϊ���ļ���+����+�����+��չ��
     * @param fileName
     * @return
     */
    private String reBuildFileName(String fileName) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyyMMddhhmmss");
        int index = fileName.indexOf(".");
        String name = fileName.substring(0, index);
        String exName = fileName.substring(index);
        String date = simpleDateFormat.format(new Date());
        return name + date + new Random().nextInt() + exName;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public File[] getMyFile() {
        return myFile;
    }
    
    public void setMyFile(File[] myFile) {
        this.myFile = myFile;
    }
    
    public String[] getMyFileContentType() {
        return myFileContentType;
    }
    
    public void setMyFileContentType(String[] myFileContentType) {
        this.myFileContentType = myFileContentType;
    }
    
    public String[] getMyFileFileName() {
        return myFileFileName;
    }
    
    public void setMyFileFileName(String[] myFileFileName) {
        this.myFileFileName = myFileFileName;
    }
    
}

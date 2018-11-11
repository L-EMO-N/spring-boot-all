package com.lemon.weixin.file.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/3/20
 */
@Component
public class FastDFSClient {

    private  static  final  String   CONF_FILENAME =  "/fastdfs/fdfs_client.conf";

    private static StorageClient1 storageClient1 = null;

    private static Logger logger = Logger.getLogger(FastDFSClient.class);


    static{
        try {
            logger.info("==================  CONF_FILENAME:" + CONF_FILENAME);
            ClientGlobal.init(CONF_FILENAME);
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
            TrackerServer trackerServer = trackerClient.getConnection();
            if(trackerServer == null){
                logger.error("getConnection  return null");
            }
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            if(storageServer == null){
                logger.error("getStoreStorage return null");
            }
            storageClient1 = new StorageClient1(trackerServer,storageServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     *
     * @param fileInputStream
     * @param fileName
     *            文件名
     * @return 返回Null则为失败
     */
    public static   String uploadFile(FileInputStream fileInputStream, String fileName){


        try {
            NameValuePair[] meta_list = null;
            byte[] file_buff = null;
            if(fileInputStream != null){
                int len = fileInputStream.available();
                file_buff = new byte[len];
                fileInputStream.read(file_buff);
            }

            String fileid = storageClient1.upload_file1(file_buff,getFileExt(fileName),meta_list);
            return  fileid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    logger.error(e);
                }
            }
        }

    }



    /**
     *
     * @param file
     *            文件
     * @param fileName
     *            文件名
     * @return 返回Null则为失败
     */
    public static   String uploadFile(File file, String fileName){

        FileInputStream fis = null;

        try {
            NameValuePair[] meta_list = null;
            fis = new FileInputStream(file);
            byte[] file_buff = null;
            if(fis != null){
                int len = fis.available();
                file_buff = new byte[len];
                fis.read(file_buff);
            }

            String fileid = storageClient1.upload_file1(file_buff,getFileExt(fileName),meta_list);
            return  fileid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if(fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    logger.error(e);
                }
            }
        }

    }

    /**
     * 根据组名和远程文件名来删除一个文件
     *
     * @param groupName
     *            例如 "group1" 如果不指定该值，默认为group1
     * @param fileName
     *            例如"M00/00/00/wKgxgk5HbLvfP86RAAAAChd9X1Y736.jpg"
     * @return 0为成功，非0为失败，具体为错误代码
     */
    public static  int deleteFile(String groupName, String fileName){
        try {
            int result = storageClient1.delete_file(groupName == null ? "group1" :groupName,fileName);
            return result;
        } catch (Exception e) {
            logger.error(e);
            return 0;
        }
    }

    /**
     * 根据fileId来删除一个文件（我们现在用的就是这样的方式，上传文件时直接将fileId保存在了数据库中）
     *
     * @param fileId
     *            file_id源码中的解释file_id the file id(including group name and filename);例如 group1/M00/00/00/ooYBAFM6MpmAHM91AAAEgdpiRC0012.xml
     * @return 0为成功，非0为失败，具体为错误代码
     */
    public  static  int deleteFile(String fileId){

        try {
            int result = storageClient1.delete_file1(fileId);
            return result;
        } catch (Exception e) {
            logger.error(e);
            return  0;
        }
    }

    /**
     * 修改一个已经存在的文件
     *
     * @param oldFileId
     *            原来旧文件的fileId, file_id源码中的解释file_id the file id(including group name and filename);例如 group1/M00/00/00/ooYBAFM6MpmAHM91AAAEgdpiRC0012.xml
     * @param file
     *            新文件
     * @param filePath
     *            新文件路径
     * @return 返回空则为失败
     */
    public  static  String modifyFile(String oldFileId, File file, String filePath){

        String fileId = null;
        try {
            //先上传
            fileId = uploadFile(file,filePath);
            if(fileId == null){
                return  null;
            }
            //再删除
            int delResult = deleteFile(oldFileId);
            if(delResult != 0){
                return null;
            }
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
        return fileId;
    }

    /**
     * 文件下载
     *
     * @param fileId
     * @return 返回一个流
     */
    public  static InputStream downloadFile(String fileId){
        try {
            byte[] bytes = storageClient1.download_file1(fileId);
            InputStream inputStream = new ByteArrayInputStream(bytes);
            return  inputStream;
        } catch (Exception e) {
            logger.error(e);
            return  null;
        }
    }

    /**
     * 获取文件后缀名（不带点）.
     *
     * @return 如："jpg" or "".
     */
    private static   String getFileExt(String fileName) {
        if (StringUtils.isBlank(fileName) || !fileName.contains(".")) {
            return "";
        } else {
            return fileName.substring(fileName.lastIndexOf(".") + 1); // 不带最后的点
        }
    }

}

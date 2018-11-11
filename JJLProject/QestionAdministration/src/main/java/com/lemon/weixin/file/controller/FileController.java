package com.lemon.weixin.file.controller;

import com.lemon.weixin.file.util.FastDFSClient;
import com.lemon.weixin.resp.DataResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

/**
 *文件上传配置
 * @author luolin
 * @date 2018/3/20
 */
@RestController
@RequestMapping("file")
public class FileController {

            @PostMapping(value = "/uploadFile")
            public DataResp<String> uploadFile(MultipartFile file,String oldPic){
                DataResp<String> resp = new DataResp<>();
                try {
                    FileInputStream inputStream = (FileInputStream) file.getInputStream();
                    String originalFilename = file.getOriginalFilename();
                    String filePath = FastDFSClient.uploadFile(inputStream, originalFilename);
                    resp.setData(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return resp;
            }

}

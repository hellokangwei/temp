package org.kt.temp.action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 图片上传
 */
@RequestMapping("/api/v1/upload")
@RestController
public class MyAct {

    @RequestMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file){

        if(file!=null) {
            File path = new File("F:\\uploadImg\\img");

            String newFileName = changeFileName(file.getOriginalFilename());
            File targetFile = new File(path, newFileName);

            if(!targetFile.getParentFile().exists()){
                targetFile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(targetFile);

                return "上传成功";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传失败";
    }

    private String changeFileName(String oldFileName) {
        String uuid = UUID.randomUUID().toString().replace("-", "");

        String fileSuffix = oldFileName.substring(oldFileName.lastIndexOf("."));

        String newFileName = uuid+fileSuffix;

        return newFileName;
    }

}

package cn.suqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

@Controller
@RequestMapping("/file")
public class FileUploadController {
    @RequestMapping("/upload")
    public String upload(@RequestParam CommonsMultipartFile uploadFile) throws Exception{
        System.out.println(uploadFile.getOriginalFilename());
        String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/upload");
        System.out.println("uploadPath:"+path);
        File newFile = new File(path+"/"+uploadFile.getOriginalFilename());
        FileCopyUtils.copy(uploadFile.getBytes(),newFile);
        return "success";
    }
}

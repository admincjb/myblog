package com.eumji.zblog.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.eumji.zblog.service.UserService;
import com.eumji.zblog.util.ImageCutUtil;
import com.eumji.zblog.util.PhotoUploadUtil;
import com.eumji.zblog.vo.PhotoResult;
import com.eumji.zblog.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 上传图片的controller
 * Created by eumji on 17-5-31.
 */
@RestController
public class ImageController {
    @Resource
    private UserService userService;

    @Resource
    private PhotoUploadUtil photoUploadUtil;

    @RequestMapping("/imageUpload")
    public PhotoResult imageUpload(@RequestParam(value = "editormd-image-file",required = true) MultipartFile file){
        PhotoResult result = null;
        //设置filename
        // String filename = new Random().nextInt(10000)+file.getOriginalFilename();
        try {
            File files = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")+file.getOriginalFilename());
            file.transferTo(files);

            result = photoUploadUtil.uploadPhoto(files.getAbsolutePath(), file.getOriginalFilename());
            return result;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;
    }

    @RequestMapping("/admin/avatar/update")
    public PhotoResult updateAvatar(HttpServletRequest request,String avatar_src, String avatar_data, @RequestParam(value = "avatar_file",required = true) MultipartFile file){
        PhotoResult result = null;
        String type = file.getContentType();
        if(type==null || !type.toLowerCase().startsWith("image/")) {
            return new PhotoResult(0,"","不支持的文件类型，仅支持图片！");
        }
        try {
            File files = new File(System.getProperty("java.io.tmpdir"),file.getOriginalFilename());
            JSONObject object = (JSONObject) JSONObject.parse(avatar_data);

            InputStream inputStream = file.getInputStream();
            ImageCutUtil.cut(inputStream, files, (int) object.getFloatValue("x"), (int) object.getFloatValue("y"), (int) object.getFloatValue("width"), (int) object.getFloatValue("height"));
            inputStream.close();

            result = photoUploadUtil.uploadPhoto(files.getAbsolutePath(), file.getOriginalFilename());
            User user = (User) request.getSession().getAttribute("user");
            userService.updateAvatar(result.getUrl(),user.getUsername());
            result.setMessage("修改图像成功！！！");

        }catch (IOException e){
            e.printStackTrace();
            return new PhotoResult(0,"","上传图片发生异常！");
        }
        return result;
    }
}

package chapter.project.chapter05.file;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Name FeiLong
 * @Date 2023/9/18
 * @注释 文件控制管理类
 */
@Controller
public class FileController {
    // 5.1文件上传
    // 向文件上传页面跳转，页面映射
    @GetMapping("/toUpload") //http://localhost:8084/toUpload
    public String toUpload() {
        return "upload";
    }

    // 文件上传
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model) {
        // 默认文件上传成功，并返回信息状态
        model.addAttribute("uploadStatus", "上传成功！");
        for (MultipartFile file : fileUpload) {
            // 获取文件名以及后缀名
            String fileName = file.getOriginalFilename();
            // 重新生成文件名
            fileName = UUID.randomUUID() + "_" + fileName;
            // 指定上传文件本地储存目录，不存在则需要提前创建
            String dirPath = "D:/Recording/SpringBootData/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (Exception e) {
                e.printStackTrace();
                // 上传失败，返回失败信息
                model.addAttribute("uploadStatus", "上传失败： " + e.getMessage());
            }
        }
        // 携带上传状态信息回调到文件上传页面
        return "upload";
    }

    // 5.2文件下载
    // 向文件下载页面跳转，页面映射
    @GetMapping("/toDownload") //http://localhost:8084/toDownload
    public String toDownload() {
        return "download";
    }

    // 文件下载管理
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(String filename) {
        // 指定要下载的文件根路径
        String dirPath = "D:/Recording/SpringBootData/";
        // 创建该文件的对象
        File file = new File(dirPath + File.separator + filename);
        // 设计响应开头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载的方式打开
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的方式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }


}

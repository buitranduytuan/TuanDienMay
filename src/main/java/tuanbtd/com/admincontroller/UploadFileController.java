package tuanbtd.com.admincontroller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class UploadFileController {

    @GetMapping("/upload_image")
    public String uploadImage() {

        return "upload/upload_image";
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam(name = "file") MultipartFile file) {
        request.setAttribute("file", file);
        String fileName = file.getOriginalFilename();
        String relativeWebPath = "/resources/upload";
        String absoluteFilePath = request.getServletContext().getRealPath(relativeWebPath);

        File uploadedFile = new File(absoluteFilePath, fileName);
        
        try {
            file.transferTo(uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "upload/view_file";
    }
    
}

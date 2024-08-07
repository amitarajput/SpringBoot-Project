package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
// import java.io.FileOutputStream;
// import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // public final String UPLOAD_DIR = "C:\\Users\\amita\\OneDrive -
    // UW\\Boot\\bootrestbook\\src\\main\\resources\\static\\image";// static path
    public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath(); // dynamic
                                                                                                         // path to
                                                                                                         // take your
                                                                                                         // file any
                                                                                                         // computer

    public FileUploadHelper() throws IOException {

    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f = false;

        try {
            // InputStream is = multipartFile.getInputStream();
            // byte data[]= new byte[is.available()];
            // is.read(data);

            // //data write
            // FileOutputStream fos = new
            // FileOutputStream(upload_dir+File.separator+multipartFile.getOriginalFilename());
            // fos.write(data);

            // fos.flush();
            // fos.close();

            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING); // above // lines and this one line is same

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
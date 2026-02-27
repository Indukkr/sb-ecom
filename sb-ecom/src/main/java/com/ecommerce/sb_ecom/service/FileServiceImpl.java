package com.ecommerce.sb_ecom.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // File names of current / original file
        String OriginalFileName = file.getOriginalFilename();

        // Generate a unique file
        String randomId = UUID.randomUUID().toString();
        //example mat.jpg--> 1234 --> 1234.jpg
        String fileName = randomId.concat(OriginalFileName.substring(OriginalFileName.lastIndexOf('.')));
        String filePath = path + File.separator + fileName;

        //check if path exist and create
        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdir();
        }

        // upload to server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        // returning filename
        return fileName;

    }
}

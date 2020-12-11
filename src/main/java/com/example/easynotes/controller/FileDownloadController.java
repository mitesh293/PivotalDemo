package com.example.easynotes.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
@RequestMapping("/download")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class FileDownloadController {
   /* @GetMapping(value = "/pdf", produces = {"application/octet-stream"})
    @ResponseBody
    public FileSystemResource downloadPDFResource() {
        String fileName = "sample_file.pdf";
        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        if (file.exists()) {
            //InputStreamResource resourc1 = new InputStreamResource(new FileInputStream(file));
            return new FileSystemResource(file);
        }

        return null;
    }*/

    @GetMapping(value = "/pdfnew")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadPDFResourceNew(HttpServletResponse response){
        String fileName = "sample_file.pdf";
        //ClassLoader classLoader = getClass().getClassLoader();

        File file = new File("/home/ec2-user/Projects/PivotalDemo/src/main/resources/"+fileName);
        System.out.println("file read ...");
        if (file.exists()) {
            InputStreamResource resource = null;
            try {
                resource = new InputStreamResource(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            log.info("downloadPDFResourceNew() method called::");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=sample_file.pdf");
            System.out.println("file exist ...");
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + "sample_file.pdf")
                    .contentLength(file.length())
                    .lastModified(file.lastModified())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        }

        return null;
    }
}

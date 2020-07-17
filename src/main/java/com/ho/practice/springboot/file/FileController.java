package com.ho.practice.springboot.file;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    
    @PostMapping(value="")
	public String saveSell(@RequestParam("myFile") MultipartFile files) { 
		System.out.println(files.getOriginalFilename());
        
		return "success"; 
	}
	

}
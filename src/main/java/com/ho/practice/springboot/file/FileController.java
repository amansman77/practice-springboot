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
	public String saveFile(@RequestParam("myFile") MultipartFile file) { 
		System.out.println("File name: " + file.getOriginalFilename());
        
		return "success"; 
	}
	

}
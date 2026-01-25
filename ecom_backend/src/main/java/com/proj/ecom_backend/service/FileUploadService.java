package com.proj.ecom_backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	@Value("${file.upload-dir}")
	private String uploadDir;

	public String saveImage(MultipartFile file) throws IOException {

		if (file.isEmpty()) {
			throw new RuntimeException("Image file is empty");
		}

		String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		Path filePath = uploadPath.resolve(fileName);
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		return fileName; // return saved filename
	}
}
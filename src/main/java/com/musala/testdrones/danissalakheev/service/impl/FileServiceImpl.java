package com.musala.testdrones.danissalakheev.service.impl;

import com.musala.testdrones.danissalakheev.exception.ResourcesException;
import com.musala.testdrones.danissalakheev.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Override
    public byte[] readFile(MultipartFile file) {
        try {
            return file.getInputStream().readAllBytes();
        } catch (IOException e) {
            log.error("File {} cannot be read, reason: {}", file.getOriginalFilename(), e);
            throw new ResourcesException("Error occurred while reading the file");
        }
    }
}

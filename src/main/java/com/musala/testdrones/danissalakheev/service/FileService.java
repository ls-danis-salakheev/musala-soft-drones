package com.musala.testdrones.danissalakheev.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    byte[] readFile(MultipartFile file);

}

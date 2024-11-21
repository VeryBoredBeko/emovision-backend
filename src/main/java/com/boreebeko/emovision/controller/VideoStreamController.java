package com.boreebeko.emovision.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/livestream")
public class VideoStreamController {

    @PostMapping
    public ResponseEntity<String> handleVideoStream(
            @RequestParam("videoChunk") MultipartFile videoChunk) {
        try {
            // Обработка chunk (например, передача в ML-модель)
            byte[] videoData = videoChunk.getBytes();
            System.out.println("Received chunk of size: " + videoData.length);

            // Реализуйте вашу логику обработки видео
            // Например, отправка данных в нейронную сеть для анализа

            return ResponseEntity.ok("Chunk processed successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing chunk");
        }
    }
}

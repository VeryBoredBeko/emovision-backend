package com.boreebeko.emovision.service;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;

public class VideoStreamHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket connection established: " + session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, org.springframework.web.socket.WebSocketMessage<?> message) throws Exception {
        System.out.println("Handle Message!");
        if (message instanceof BinaryMessage) {
            byte[] payload = ((BinaryMessage) message).getPayload().array();

            // Обработка видеоданных
            System.out.println("Received chunk of size: " + payload.length);

            // Пример: передача в ML-модель для анализа
            processVideoChunk(payload);
        }
    }

    private void processVideoChunk(byte[] videoChunk) {
        // Здесь можно передать данные в модель для анализа
        System.out.println("Processing video chunk...");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.err.println("Error in WebSocket transport: " + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("WebSocket connection closed: " + session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return true;
    }
}


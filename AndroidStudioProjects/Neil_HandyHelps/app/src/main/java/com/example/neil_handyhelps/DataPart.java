package com.example.neil_handyhelps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataPart {
    private String fileName;
    private byte[] content;
    private String type;

    public DataPart(String fileName, byte[] content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(content);
    }

    public long getContentLength() {
        return content.length;
    }

    public static DataPart fromInputStream(String fileName, InputStream inputStream) throws IOException {
        byte[] content = inputStreamToBytes(inputStream);
        return new DataPart(fileName, content);
    }

    private static byte[] inputStreamToBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        return outputStream.toByteArray();
    }
}

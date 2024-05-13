package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.DocumentDto;
import com.bri.mobile.Entity.Document;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface DocumentFace {
    List<DocumentDto> getAllDocuments();
    DocumentDto getDocumentById(int id);
    DocumentDto getDocumentByRequest(Request request);
    DocumentDto addDocument(DocumentDto document);
    DocumentDto updateDocument(DocumentDto document, int id);
    void deleteDocument(int id);

}

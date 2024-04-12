package com.bri.mobile.Face;

import com.bri.mobile.Entity.Document;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface DocumentFace {
    List<Document> getAllDocuments();
    Document getDocumentById(int id);
    Document addDocument(Document document);
    Document updateDocument(Document document, int id);
    void deleteDocument(int id);
}

package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.DocumentMap;
import com.bri.mobile.DTO.model.DocumentDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Face.DocumentFace;
import com.bri.mobile.Repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentService implements DocumentFace {
    @Autowired
    DocumentRepo documentRepo;
    public List<DocumentDto> getAllDocuments(){
        return null;
    }
    public DocumentDto getDocumentById(int id){
        return null;
    }
    public DocumentDto addDocument(DocumentDto document){
        return DocumentMap.toDocumentDto(documentRepo.save(DocumentMap.toDocumentEntity(document)));
    }
    public DocumentDto updateDocument(DocumentDto document, int id){
        return null;
    }
    public void deleteDocument(int id){
        documentRepo.deleteById(id);
    }
    public DocumentDto getDocumentByRequest(Request request){
        return DocumentMap.toDocumentDto(documentRepo.findByRequest(request));
    }
}

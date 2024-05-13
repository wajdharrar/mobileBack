package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.DocumentDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Face.DocumentFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentFace documentFace;
    @PostMapping("/add")
    DocumentDto addDocument(@RequestBody DocumentDto documentDto){
        return documentFace.addDocument(documentDto);
    }
    @DeleteMapping("delete/{id}")
    void deleteCart(@PathVariable int id){
        documentFace.deleteDocument(id);
    }
    @PostMapping("/request")
    DocumentDto getDocumentByRequest(@RequestBody Request request){
        return documentFace.getDocumentByRequest(request);
    }
}

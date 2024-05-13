package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.DocumentDto;
import com.bri.mobile.DTO.model.RoleDto;
import com.bri.mobile.Entity.Document;
import com.bri.mobile.Entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentMap {
    public static DocumentDto toDocumentDto(Document document){
        return DocumentDto.builder()
                .idDocument(document.getIdDocument())
                .nationalId(document.getNationalId())
                .bankStatement(document.getBankStatement())
                .birthCertificate(document.getBirthCertificate())
                .proofOfEmployement(document.getProofOfEmployement())
                .taxReturn(document.getTaxReturn())
                .proofOfIncome(document.getProofOfIncome())
                .taxReturn(document.getTaxReturn())
                .request(RequestMap.toRequestDto(document.getRequest()))
                .build();
    }
    public static Document toDocumentEntity (DocumentDto documentDto){
        return Document.builder()
                .idDocument(documentDto.getIdDocument())
                .nationalId(documentDto.getNationalId())
                .bankStatement(documentDto.getBankStatement())
                .birthCertificate(documentDto.getBirthCertificate())
                .proofOfEmployement(documentDto.getProofOfEmployement())
                .taxReturn(documentDto.getTaxReturn())
                .proofOfIncome(documentDto.getProofOfIncome())
                .taxReturn(documentDto.getTaxReturn())
                .request(RequestMap.toRequestEntity(documentDto.getRequest()))
                .build();
    }
    public static List<DocumentDto> toDocumentListDto(List<Document> documents){
        return documents.stream()
                .map(document ->toDocumentDto(document))
                .collect(Collectors.toList());
    }
    public static List<Document> toDocumentListEntity(List<DocumentDto> documentDtos ){
        return documentDtos.stream()
                .map(documentDto ->toDocumentEntity(documentDto))
                .collect(Collectors.toList());
    }
}

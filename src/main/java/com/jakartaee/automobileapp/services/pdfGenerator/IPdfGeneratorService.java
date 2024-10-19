package com.jakartaee.automobileapp.services.pdfGenerator;


import com.jakartaee.automobileapp.entities.Mission;

public interface IPdfGeneratorService {

    byte[] generateMissionPdf(Mission mission);

}

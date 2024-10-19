package com.jakartaee.automobileapp.services.Alerte;


import com.jakartaee.automobileapp.entities.Alerte;
import com.jakartaee.automobileapp.enums.AlerteStatus;
import com.jakartaee.automobileapp.records.AlerteFilter;

import java.util.List;

public interface IAlerteService {


    Alerte createAlerte(Alerte alerte);
    Alerte updateAlerte(Long id,Alerte alerte);
    Alerte getAlerte(Long id);
    void deleteAlerte(Long id);
    List<Alerte> getAllAlertes();


    List<Alerte> getAlertesByDateReminder();
    void checkAndSendNotifications();

    List<Alerte> filterAlertesEnCour(AlerteFilter filter);
    List<Alerte> filterAlertesDone(AlerteFilter filter);

    List<String> getAllTypeAlertes();

    List<String> getAllAlertesMatricules();

    Alerte finishAlerte(Long id);

    List<Alerte> getAllAlerteByStatus(AlerteStatus status);

    long countAlertes();
}

package com.jakartaee.automobileapp.controllers.Alerte;

import com.jakartaee.automobileapp.entities.Alerte;
import com.jakartaee.automobileapp.entities.Mission;
import com.jakartaee.automobileapp.enums.AlerteStatus;
import com.jakartaee.automobileapp.exceptions.NoVehiculesFoundException;
import com.jakartaee.automobileapp.records.AlerteFilter;
import com.jakartaee.automobileapp.services.Alerte.IAlerteService;
import com.jakartaee.automobileapp.services.Mission.IMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("alertes")
public class AlerteController {

    private final IAlerteService iAlerteService;
    private final IMissionService iMissionService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerte(@PathVariable Long id) {
        iAlerteService.deleteAlerte(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<Alerte> createAlerte(@RequestBody Alerte alerte) {
        Alerte alerteCreated = iAlerteService.createAlerte(alerte);
        return ResponseEntity.ok(alerteCreated);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Alerte> updateAlerte(@PathVariable Long id , @RequestBody Alerte alerte) {
        Alerte alerteUpdated = iAlerteService.updateAlerte(id,alerte);
        return ResponseEntity.ok(alerteUpdated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerte> getAlerte(@PathVariable Long id) {
        Alerte alerte = iAlerteService.getAlerte(id);
        return ResponseEntity.ok(alerte);
    }

    @GetMapping
    public ResponseEntity<List<Alerte>> getAlertes() {
        List<Alerte> alertes = iAlerteService.getAllAlertes();
        return ResponseEntity.ok(alertes);
    }



    @GetMapping("/notifications")
    public ResponseEntity<List<Alerte>> getAlertesForNotification() {
        List<Alerte> alertes = iAlerteService.getAlertesByDateReminder();
        return ResponseEntity.ok(alertes);
    }


    @GetMapping("/missions/{id}")
    public ResponseEntity<List<Mission>> getAlertesOfMissionAcceptedByDepartement(@PathVariable Long id) {
        List<Mission> missions = iMissionService.getMissionAcceptedByDepartement(id);
        return ResponseEntity.ok(missions);
    }

    @PostMapping("/trigger-notifications")
    public ResponseEntity<Void> triggerNotifications() {
        iAlerteService.checkAndSendNotifications();
        return ResponseEntity.ok().build();
    }




    @PostMapping("/encour/filter")
    public ResponseEntity<?> filterAlertesEnCour(@RequestBody AlerteFilter filter) {
        try {
            List<Alerte> alertes = iAlerteService.filterAlertesEnCour(filter);
            return new ResponseEntity<>(alertes, HttpStatus.OK);
        } catch (NoVehiculesFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/done/filter")
    public ResponseEntity<?> filterAlertesDone(@RequestBody AlerteFilter filter) {
        try {
            List<Alerte> alertes = iAlerteService.filterAlertesDone(filter);
            return new ResponseEntity<>(alertes, HttpStatus.OK);
        } catch (NoVehiculesFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/types")
    public List<String> getAllTypeAlertes() {
        return iAlerteService.getAllTypeAlertes();
    }


    @GetMapping("/immatriculations")
    public List<String> getAllAlertesMatricules() {
        return iAlerteService.getAllAlertesMatricules();
    }


    @GetMapping("/{id}/finish")
    public ResponseEntity<Alerte> finishAlerte(@PathVariable Long id) {
        Alerte alerte = iAlerteService.finishAlerte(id);
        return ResponseEntity.ok(alerte);
    }


    @GetMapping("/status/{status}")
    public ResponseEntity<List<Alerte>> getAllOperationsByTypeOperation(@PathVariable AlerteStatus status) {
        List<Alerte> alertes = iAlerteService.getAllAlerteByStatus(status);
        return ResponseEntity.ok(alertes);
    }

}

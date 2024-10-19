package com.jakartaee.automobileapp.services.Notification;


import com.jakartaee.automobileapp.entities.Alerte;

public interface INotificationService {

    void sendNotification(Alerte alerte);
}

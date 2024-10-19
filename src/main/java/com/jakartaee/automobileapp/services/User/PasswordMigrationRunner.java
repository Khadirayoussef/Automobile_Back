package com.jakartaee.automobileapp.services.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PasswordMigrationRunner implements CommandLineRunner {

    private final PasswordMigrationService passwordMigrationService;

    public PasswordMigrationRunner(PasswordMigrationService passwordMigrationService) {
        this.passwordMigrationService = passwordMigrationService;
    }

    @Override
    public void run(String... args) throws Exception {
        passwordMigrationService.migratePasswords();
    }
}
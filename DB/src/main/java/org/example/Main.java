package org.example;

import entities.Objects;
import entities.Roles;
import operations.DatabaseManager;

public class Main {

    public static void main(String[] args) {

        Objects objects = new Objects();
        DatabaseManager dbManager = new DatabaseManager();

        dbManager.addToDatabase(objects.getRoles());
        dbManager.addToDatabase(objects.getLogins());
        dbManager.addToDatabase(objects.getOrder());

        dbManager.setFieldValue(objects.getRoles().get(0).getClass(),1,"role","hhhhhhh");
        System.out.println(dbManager.getFromDatabaseById(Roles.class,1));
        System.out.println("First i was a: "+dbManager.getFromDatabaseByRevision(Roles.class,1,1));
   }
}


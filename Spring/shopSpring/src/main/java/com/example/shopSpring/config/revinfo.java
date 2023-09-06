package com.example.shopSpring.config;

import com.example.shopSpring.data.roles.controller.RoleRevisionListener;
import jakarta.persistence.Entity;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Setter
@Entity
@RevisionEntity(RoleRevisionListener.class)
public class revinfo extends DefaultRevisionEntity {

    String modified_by;
}


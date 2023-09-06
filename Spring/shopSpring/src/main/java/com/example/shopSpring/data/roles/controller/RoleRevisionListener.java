package com.example.shopSpring.data.roles.controller;

import com.example.shopSpring.config.revinfo;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;

public class RoleRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        revinfo customRevisionEntity = (revinfo) revisionEntity;
        String modifiedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        customRevisionEntity.setModified_by(modifiedBy);
    }
}

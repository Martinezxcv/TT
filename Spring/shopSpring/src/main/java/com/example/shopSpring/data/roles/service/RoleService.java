package com.example.shopSpring.data.roles.service;

import com.example.shopSpring.data.roles.model.Roles;
import com.example.shopSpring.data.roles.model.RolesDto;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public interface RoleService {

    List<RolesDto> getAllRoles();

    void addRole(RolesDto role);

    Optional<RolesDto> getRoleById(int id);

    String changeRoleValue(int roleId, String newValue);

    AtomicReference<String> deleteRoleById(int id);

    List<RolesDto> getRoleAuditChangesById(int id);
}

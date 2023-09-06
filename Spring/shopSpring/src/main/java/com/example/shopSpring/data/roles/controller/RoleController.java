package com.example.shopSpring.data.roles.controller;

import com.example.shopSpring.data.roles.model.Roles;
import com.example.shopSpring.data.roles.model.RolesDto;
import com.example.shopSpring.data.roles.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(path ="role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public @ResponseBody Iterable<RolesDto> getAllRoles(){
        return roleService.getAllRoles();
    }
    @GetMapping(path = "/{id}")
    public Optional<RolesDto> getRoleById(@PathVariable int id){return roleService.getRoleById(id);}
    @PostMapping
    public String addRole(@RequestBody RolesDto role){
        roleService.addRole(role);
        return "Added";
    }
    @DeleteMapping(path = "/{id}")
    public AtomicReference<String> deleteRoleById(@PathVariable int id) {
        return roleService.deleteRoleById(id);
    }

    @GetMapping(path = "/audited/{id}")
    public List getRoleAudit(@PathVariable int id){return roleService.getRoleAuditChangesById(id);}

    @PatchMapping(path = "{id}")
    public String changeRole(@PathVariable int id, @RequestBody RolesDto role){return roleService.changeRoleValue(id,role.getRole());}
}

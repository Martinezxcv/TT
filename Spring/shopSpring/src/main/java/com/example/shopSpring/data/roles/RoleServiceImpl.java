package com.example.shopSpring.data.roles;

import com.example.shopSpring.data.roles.mapper.RolesMapper;
import com.example.shopSpring.data.roles.model.Roles;
import com.example.shopSpring.data.roles.model.RolesDto;
import com.example.shopSpring.data.roles.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final AuditReader auditReader;
    private final RolesMapper rolesMapper;

    @Override
    public List<RolesDto> getAllRoles() {
        return rolesMapper.toDtoList(roleRepository.findAll());
    }

    @Override
    public void addRole(RolesDto role) {
        roleRepository.save(rolesMapper.fromDto(role));
    }

    @Override
    public Optional<RolesDto> getRoleById(int id) {
        return Optional.ofNullable(rolesMapper.toDto(roleRepository.findById(id)));
    }
@Override
    public String changeRoleValue(int roleId, String newValue ) {
    RolesDto role = getRoleById(roleId).orElse(null);

        if (role != null) {
                role.setRole(newValue);
                roleRepository.save(rolesMapper.fromDto(role));
                return "Changed";
        }
        return "Not changed";
    }

    @Override
    public AtomicReference<String> deleteRoleById(int id) {
        AtomicReference<String> result = new AtomicReference<>("Not found");
        getRoleById(id).ifPresent(role -> {roleRepository.deleteById(id);
            result.set("Succesfully deleted");});
        return result;
    }

    @Override
    public List getRoleAuditChangesById(int id) {
        return auditReader.createQuery()
                .forRevisionsOfEntity(Roles.class, true, true)
                .add(AuditEntity.id().eq(id))
                .getResultList();
    }
}

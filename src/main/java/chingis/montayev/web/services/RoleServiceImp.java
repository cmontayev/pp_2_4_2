package chingis.montayev.web.services;

import chingis.montayev.web.dao.RoleDaoImp;
import chingis.montayev.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService {
    private RoleDaoImp roleDaoImp;

    @Autowired
    public RoleServiceImp(RoleDaoImp roleDaoImp) {
        this.roleDaoImp = roleDaoImp;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAll() {
        return roleDaoImp.getAll();
    }

    @Transactional
    @Override
    public void add(Role role) {
        roleDaoImp.add(role);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        roleDaoImp.delete(id);
    }

    @Transactional
    @Override
    public Role getById(Long id) {
        return roleDaoImp.getById(id);
    }

    @Transactional
    @Override
    public Role getByName(String name) {
        return roleDaoImp.getByName(name);
    }

    @Transactional
    @Override
    public void upDate(Role roleUpdDate) {
        roleDaoImp.upDate(roleUpdDate);
    }
}

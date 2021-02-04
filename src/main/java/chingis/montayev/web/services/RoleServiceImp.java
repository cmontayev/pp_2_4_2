package chingis.montayev.web.services;

import chingis.montayev.web.dao.RoleDao;
import chingis.montayev.web.dao.RoleDaoImp;
import chingis.montayev.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Transactional
    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        roleDao.delete(id);
    }

    @Transactional
    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Transactional
    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }

    @Transactional
    @Override
    public void upDate(Role roleUpdDate) {
        roleDao.upDate(roleUpdDate);
    }
}

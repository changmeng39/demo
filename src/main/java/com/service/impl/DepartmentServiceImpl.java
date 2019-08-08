package com.service.impl;

import com.dao.DepartmentDao;
import com.entity.Department;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public int insert(Department department) {
        Department dep = departmentDao.save(department);
        return dep!=null?1:0;
    }
}

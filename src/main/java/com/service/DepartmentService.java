package com.service;

import com.entity.Department;
import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    int insert(Department department);
}

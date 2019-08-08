package com.controller;

import com.entity.Department;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("depList")
    public List<Department> depList(){
        return departmentService.findAll();
    }

    @RequestMapping("insertDep")
    public int insertDep(Department department){
        department.setUserId(1);
        department.setDepName("运维");
        return departmentService.insert(department);
    }
}

package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Department implements Serializable {

    private static final long serialVersionUID = -3201414098161380992L;

    @Id
    @GeneratedValue
    private int id;

    private int userId;

    private String depName;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDepName() {
        return depName;
    }
}

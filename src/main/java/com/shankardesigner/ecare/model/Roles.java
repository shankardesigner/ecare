package com.shankardesigner.ecare.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolesId;
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List< User > users;

    public Roles() {
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

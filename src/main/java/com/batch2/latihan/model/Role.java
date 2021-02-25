package com.batch2.latihan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "m_role")
public class Role {

    @Id
    private Integer id;
    private String roleName;
    private String permissionDesc;

    @OneToMany(mappedBy = "role")
    private List<Permission> permission;

}

package com.batch2.latihan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SqlResultSetMapping(name = "QueryNativePakeJoin", entities = {
        @EntityResult( entityClass = CustomMappingModel.class, fields = {
                @FieldResult(name = "id" , column = "id"),
                @FieldResult(name = "username" , column = "username"),
                @FieldResult(name = "roleName", column = "role_name"),
                @FieldResult(name = "url", column = "url"),
        })
})
public class CustomMappingModel {

    @Id
    private Integer id;
    private String username;
    private String roleName;
    private String url;

}

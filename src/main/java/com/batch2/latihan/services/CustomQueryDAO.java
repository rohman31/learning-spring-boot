package com.batch2.latihan.services;

import com.batch2.latihan.model.CustomMappingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CustomQueryDAO {

    @Autowired
    private EntityManager en;

    public List<CustomMappingModel> getCustomQueryNative(String userName){
        String nativeQueryScript = "select RAND(100) AS id, mu.username, mr.role_name, mp.url from m_user mu \n " +
                "inner join m_role mr on mr.id = mu.role_id \n" +
                "inner join m_permission mp on mp.role_id = mr.id where mu.username = :userName \n";
        Query q = en.createNativeQuery(nativeQueryScript, "QueryNativePakeJoin");

//        List<CustomMappingModel> list = q.getResultList();
        List<CustomMappingModel> list = q.setParameter("userName",userName).getResultList();

        return  list;
    }
}

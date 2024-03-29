package com.example.feast.Repo;

import com.example.feast.Entity.ManageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageTableRepo extends JpaRepository<ManageTable,Integer> {
    boolean existsByTableName(String tableName);
}

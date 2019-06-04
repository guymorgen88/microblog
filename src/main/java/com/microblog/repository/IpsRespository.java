package com.microblog.repository;

import com.microblog.model.Ips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// Repository - a class that talks to the database
@Repository
public interface IpsRespository extends JpaRepository<Ips, Integer> {

    // custom query to search by ip
    List<Ips> findByIpContaining(String ip);
}
package com.kukuruznyak.springmvc.mvc.repository;

import com.kukuruznyak.springmvc.mvc.model.Router;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouterRepository extends JpaRepository<Router, Long> {

    @Query("select r from Router r join r.event e where e.id = :eventId")
    List<Router> getAllRoutersByEventId(@Param("eventId") Long eventId);

}
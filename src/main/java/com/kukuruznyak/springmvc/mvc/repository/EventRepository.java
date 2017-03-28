package com.kukuruznyak.springmvc.mvc.repository;

import com.kukuruznyak.springmvc.mvc.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}


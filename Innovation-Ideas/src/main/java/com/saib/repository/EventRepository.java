package com.saib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saib.models.Events;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Events,Long> {
	//public List<Events> findByEventType(String EventType);

}

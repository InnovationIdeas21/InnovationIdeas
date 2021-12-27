package com.saib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saib.models.Users;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>  {

}

package com.example.demo.repository;

import com.example.demo.entity.CTable;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    List<User> findByRole(Role role);

//    @Query("select 'ctable' from User user where u")

}

package com.programming.techie.springngblog.repository;


import com.programming.techie.springngblog.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}
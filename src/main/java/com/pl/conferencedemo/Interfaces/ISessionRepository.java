package com.pl.conferencedemo.Interfaces;

import com.pl.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISessionRepository extends JpaRepository<Session,Long> {
}

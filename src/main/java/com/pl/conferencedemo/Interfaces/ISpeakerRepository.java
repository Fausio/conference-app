package com.pl.conferencedemo.Interfaces;

import com.pl.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpeakerRepository extends JpaRepository<Speaker, Long> {
}

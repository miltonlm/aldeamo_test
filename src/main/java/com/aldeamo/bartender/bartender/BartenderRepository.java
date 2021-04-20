package com.aldeamo.bartender.bartender;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The repository for the bartend entity.
 * */
public interface BartenderRepository extends JpaRepository<Bartender, Long> {
}

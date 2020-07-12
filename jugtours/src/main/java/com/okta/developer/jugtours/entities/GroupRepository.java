package com.okta.developer.jugtours.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long>
{
    Group findByName(String name);
    // a change here
    // emily made a change here
}
package com.okta.developer.jugtours.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long>
{
    // sung made a change here
    Group findByName(String name);
    // a change here
}


package com.okta.developer.jugtours.controllers;

import com.okta.developer.jugtours.entities.Group;
import com.okta.developer.jugtours.entities.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class GroupController
{

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/groups")
    Collection<Group> groups()
    {
        return groupRepository.findAll();
    }

    @PostMapping("/groups")
    ResponseEntity<Group> createGroup(@RequestBody Group group) throws URISyntaxException
    {
        logger.info("Request to create group: {}", group);
        Group createdGroup = groupRepository.save(group);
        return ResponseEntity.created(new URI("/api/group/" + createdGroup.getId())).body(createdGroup);
    }

    @GetMapping("/groups/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id)
    {
        Optional<Group> group = groupRepository.findById(id);
        return group.map(
                response ->
                        ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/groups")
    ResponseEntity<Group> updateGroup(@RequestBody Group group)
    {
        logger.info("Request to update group: {}", group);
        Group updatedGroup = groupRepository.save(group);
        return ResponseEntity.ok().body(updatedGroup);
    }

    @DeleteMapping("/groups/{id}")
    ResponseEntity<?> deleteGroup(@PathVariable Long id)
    {
        logger.info("Request to deletegroup: {}", id);
        groupRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}

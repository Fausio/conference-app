package com.pl.conferencedemo.controllers;

import com.pl.conferencedemo.Interfaces.ISessionRepository;
import com.pl.conferencedemo.models.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private ISessionRepository sessionRepository;

    //list and point
    @GetMapping
    public List<Session> read(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session Create (@RequestBody final Session model){
        return sessionRepository.saveAndFlush(model);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public  void remove(@PathVariable Long id){
        // also nedd to check for children records before deleting.
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session model){
// if not ok return 400 bad payload
        Session modelToUpdate = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(model, modelToUpdate , "session_id");
        return sessionRepository.saveAndFlush(modelToUpdate);
    }
}

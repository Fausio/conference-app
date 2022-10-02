package com.pl.conferencedemo.controllers;

import com.pl.conferencedemo.Interfaces.ISpeakerRepository;
import com.pl.conferencedemo.models.Speaker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private ISpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> read() {
       return speakerRepository.findAll() ;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return  speakerRepository.getReferenceById(id);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public  void remove(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public  Speaker update(@PathVariable Long id, @RequestBody Speaker model){
        // todo validation etc
        Speaker modelToUpdate  = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(model,modelToUpdate, "speaker_id");
        return  speakerRepository.saveAndFlush(modelToUpdate);
    }

}

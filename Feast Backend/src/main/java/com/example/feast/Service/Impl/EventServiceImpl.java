package com.example.feast.Service.Impl;
import com.example.feast.Entity.*;
import com.example.feast.Pojo.EventPojo;
import com.example.feast.Repo.EventRepo;
import com.example.feast.Repo.UserRepo;
import com.example.feast.Service.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    private final UserRepo userRepo;


    @Override
    public void saveEvent(EventPojo eventPojo) {
        Event event=new Event();

//        event.setName(eventPojo.getName());

        if(eventPojo.getId()!=null){
            event=eventRepo.findById(eventPojo.getId()).get();
        }
        eventRepo.save(event); // insert query
    }
    @Override
    public List<Event> getALl() {
        return this.eventRepo.findAll();
    }

    @Override
    public Optional<Event> getById(Long id) {
        return Optional.empty();
    }
}


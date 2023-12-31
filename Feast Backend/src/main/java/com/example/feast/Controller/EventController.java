package com.example.feast.Controller;
import com.example.feast.Pojo.EventPojo;
import com.example.feast.Service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @PostMapping(value="/save")
    public String saveEvent(@Valid @RequestBody EventPojo eventPojo){
        eventService.saveEvent(eventPojo);
        return "Saved";
    }

}

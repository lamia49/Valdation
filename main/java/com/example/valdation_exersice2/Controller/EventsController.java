package com.example.valdation_exersice2.Controller;

import com.example.valdation_exersice2.ApiResponse.ApiResponse;
import com.example.valdation_exersice2.Model.EventsModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {
    ArrayList<EventsModel> eventss=new ArrayList<>();


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid EventsModel event , Errors errors){
        if(errors.hasErrors()){
           String message = errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
        }
        eventss.add(event);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/display")
    public ArrayList display(){
        return eventss;
    }

    @PutMapping("update/{index}")
    public ResponseEntity update(@PathVariable int index, @RequestBody @Valid EventsModel event, Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        eventss.set(index,event);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{index}")

    public ResponseEntity delete(@PathVariable int index){
        eventss.remove(index);
        return ResponseEntity.status(200).body("deleted");
    }


    @PutMapping("/change/{id}/{capacity}")
    
    public ResponseEntity chang(@PathVariable int id ,@PathVariable  int capacity ){


        if(capacity<25){
            return ResponseEntity.status(400).body("Capacity must be more than 25");
        }

        for (EventsModel event:eventss){
            if(event.getId()==id){

                event.setCapacity(capacity);
            }
        }
        return ResponseEntity.status(200).body("Changed");
    }
    @GetMapping("search/{id}")
    public ResponseEntity search(@PathVariable int id){
        for (EventsModel e:eventss){
            if(e.getId()==id){
                return ResponseEntity.status(200).body(e.toString());
            }
        }
        return ResponseEntity.status(400).body("not Found");
    }
}

package com.example.valdation_exersice.Controller;

import com.example.valdation_exersice.Model.Project;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vi/projects")
public class ProjectController {
    ArrayList<Project>projects=new ArrayList<>();
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Project project , Errors error){
        if(error.hasErrors()){
            String massege=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        projects.add(project);
      return   ResponseEntity.status(200).body("User Aded");
    }
    @GetMapping("/display")
    public ArrayList<Project> display(){
        return projects;
    }

    @PutMapping("/update/{index}")
    public ResponseEntity update(@PathVariable int index, @RequestBody @Valid Project project , Errors error){
        if(error.hasErrors()){
            String massege =error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        projects.set(index,project);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/delete/{index}")

    public ResponseEntity delete(@PathVariable int index){

        projects.remove(index);

        return ResponseEntity.status(200).body("Deleted");
    }
    @GetMapping("/search/{title}")

    public ResponseEntity search(@PathVariable String title){
        for (Project p:projects){
            if(p.getTitl().equalsIgnoreCase(title)){
                return ResponseEntity.status(200).body(p.toString());
            }
        }
        return ResponseEntity.status(200).body("not found");
    }
    @GetMapping("projects/{compnyName}")

    public List compny(@PathVariable String compnyName){
        ArrayList<Project> Projectscompny=new ArrayList<>();
        for(Project p:projects){
            if(p.getCompanyName().equalsIgnoreCase(compnyName)){
                Projectscompny.add(p);
            }
        }
        return Projectscompny;
    }

}

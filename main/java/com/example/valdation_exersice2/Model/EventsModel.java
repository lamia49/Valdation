package com.example.valdation_exersice2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
public class EventsModel {
    @NotNull
    @Min(value = 2,message = " id Should be more then 2")
    private int id;
    @NotNull
    @Size(min = 15,message = " descrbtion Should be more then 15")
    private String description;
    @NotNull
    @Min(value = 25,message = "Capacity must be more than 25")
    private Integer capacity;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
}

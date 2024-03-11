package com.example.valdation_exersice.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    @NotNull(message = "ID Should't Be null")
    @Min(value = 2 ,message = "id should be mor then 2")
    private int id;
    @NotNull(message = "title Should't Be null")
    @Size(min = 8,message = " titleShould be more then 8")
    private String titl;
    @NotNull(message = "Descrption Should't Be null")
    @Size(min = 15 , message = "Descrption Should be more then 15")
    private String descrption;
    @NotNull(message = "status Should't Be null")
    @Pattern(regexp = "^(Not Started|In Progress|Completed)$",message = "should be in prograss or not started or completed")
    private String status;
    @NotNull(message = "Name Should't Be null")
    @Size(min = 6 ,message = " Name Should be more then 6")
    private String CompanyName;
}

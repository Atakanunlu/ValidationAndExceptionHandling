package com.atakanunlu.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
//@Builder
@NoArgsConstructor
public class UserDto {
    private int userId;
    @NotBlank(message = "İsim boş olamaz.")
    private String name;
    @Email(message = "Geçersiz email adresi.")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Geçersiz numara.")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(65)
    private int age;
    @NotBlank(message = "Uyruk boş olamaz.")
    private String nationality;
}

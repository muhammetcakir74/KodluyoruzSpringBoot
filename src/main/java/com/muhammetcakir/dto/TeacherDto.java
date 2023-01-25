package com.muhammetcakir.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "ad soyad alanını boş geçemessiz.")
    @Size(min=1,max = 255)
    private String teacherNameSurname;

    @NotEmpty(message = "email alanını boş geçemessiz.")
    @Email(message = "Uygun formatta email girmediniz")
    private String teacherEmail;

    @NotEmpty(message = "şifreyi boş geçemessiz.")
/*    @Min(value = 5,message = "minunum 5 karakter")
    @Max(value = 10,message = "maxiumum 10 karakter")*/
    @Size(min=5,max = 10)
    private String teacherPassword;
}

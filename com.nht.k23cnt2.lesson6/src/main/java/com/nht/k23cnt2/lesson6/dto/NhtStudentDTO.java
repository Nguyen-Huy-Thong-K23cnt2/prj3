package com.nht.k23cnt2.lesson6.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhtStudentDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
}

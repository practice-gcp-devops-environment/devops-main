package org.example.devopsmain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelloRequestDto {
    private String helloName;
    private String helloPassword;
}

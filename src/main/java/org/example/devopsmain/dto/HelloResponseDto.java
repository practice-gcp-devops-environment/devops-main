package org.example.devopsmain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelloResponseDto {
    private Long helloId;
    private String helloName;
    private String helloPassword;
    private String helloImage;
}

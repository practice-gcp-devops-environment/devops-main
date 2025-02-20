package org.example.devopsmain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hello")
public class HelloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hello_id")
    private Long helloId;

    @Column(name = "hello_name")
    private String helloName;

    @Column(name = "hello_password")
    private String helloPassword;

    @Column(name = "hello_image")
    private String helloImage;
}

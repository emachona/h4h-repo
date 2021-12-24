package com.example.httpCommunication;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}

package br.edu.utfpr.pb.pw44s.server.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String cpf;
}
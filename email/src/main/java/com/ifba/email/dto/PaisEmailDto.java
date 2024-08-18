package com.ifba.email.dto;

import java.util.List;

public record PaisEmailDto(String nomePais, List<String> emails) {
}

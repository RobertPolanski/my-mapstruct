package de.it4ipm.mymapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record PersonDTO(String id, String name) {
}

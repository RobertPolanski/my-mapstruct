package de.it4ipm.mymapstruct.dto;

import lombok.Builder;

@Builder
public record SimpleSource(String name, String description) {}

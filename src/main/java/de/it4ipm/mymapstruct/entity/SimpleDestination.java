package de.it4ipm.mymapstruct.entity;

import lombok.Builder;

@Builder
public record SimpleDestination(String name, String description) {}

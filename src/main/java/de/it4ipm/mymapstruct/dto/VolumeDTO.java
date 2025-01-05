package de.it4ipm.mymapstruct.dto;

import lombok.Builder;

@Builder
public record VolumeDTO(int volume, String description) {}


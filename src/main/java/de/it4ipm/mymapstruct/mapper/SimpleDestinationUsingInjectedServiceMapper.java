package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.SimpleSource;
import de.it4ipm.mymapstruct.entity.SimpleDestination;
import de.it4ipm.mymapstruct.service.SimpleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SimpleDestinationUsingInjectedServiceMapper {

    @Autowired
    protected SimpleService simpleService;

    @Mapping(target = "name", expression = "java(simpleService.enrichName(source.getName()))")
    public abstract SimpleDestination sourceToDestination(SimpleSource source);

    public abstract SimpleSource destinationToSource(SimpleDestination destination);
}

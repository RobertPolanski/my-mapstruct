package de.it4ipm.mymapstruct.mapper;


import de.it4ipm.mymapstruct.dto.SimpleSource;
import de.it4ipm.mymapstruct.entity.SimpleDestination;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {

    SimpleDestination sourceToDestination(SimpleSource source);

    SimpleSource destinationToSource(SimpleDestination destination);

}

package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.SimpleSource;
import de.it4ipm.mymapstruct.entity.SimpleDestination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SimpleDestinationUsingInjectedIntegrationMapperTest {
    @Autowired
    private SimpleDestinationUsingInjectedServiceMapper mapper;

    @Test
    public void givenSourceToDestination_whenMaps_thenNameEnriched() {
        // Given
        SimpleSource source = new SimpleSource();
        source.setName("Bob");
        source.setDescription("The Builder");

        // When
        SimpleDestination destination = mapper.sourceToDestination(source);

        // Then
        assertThat(destination).isNotNull();
        assertThat(destination.getName()).isEqualTo("-:: Bob ::-");
        assertThat(destination.getDescription()).isEqualTo("The Builder");
    }
}

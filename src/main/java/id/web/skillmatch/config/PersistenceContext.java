package id.web.skillmatch.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.ZonedDateTime;
import java.util.Optional;

@EnableJpaRepositories(
    transactionManagerRef = "transactionManager",
    entityManagerFactoryRef = "entityManagerFactory",
    value = "id.web", includeFilters = @ComponentScan.Filter(pattern = "..*JpaRepository", type = FilterType.REGEX)
)
@EntityScan("id.web")
@Configuration
public class PersistenceContext {

    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}

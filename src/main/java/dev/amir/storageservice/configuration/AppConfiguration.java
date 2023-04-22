package dev.amir.storageservice.configuration;

import dev.amir.storageservice.entity.Storage;
import dev.amir.storageservice.rest.StorageRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableJpaRepositories(basePackageClasses = StorageRepository.class)
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class AppConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.getExposureConfiguration()
                .forDomainType(Storage.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH, HttpMethod.PUT))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH, HttpMethod.PUT));
    }
}

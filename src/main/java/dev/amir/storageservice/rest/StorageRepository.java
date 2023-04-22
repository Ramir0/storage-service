package dev.amir.storageservice.rest;

import dev.amir.storageservice.entity.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "storages", path = "storages")
public interface StorageRepository extends CrudRepository<Storage, Long> {

    @Override
    @RestResource(exported = false)
    Iterable<Storage> findAll();

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    Collection<Storage> findAllByIdIn(Collection<Long> ids);
}

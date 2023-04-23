package dev.amir.storageservice.repository;

import dev.amir.storageservice.entity.Storage;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface StorageRepository extends CrudRepository<Storage, Long> {
    Collection<Storage> findAllByIdIn(Collection<Long> ids);
}

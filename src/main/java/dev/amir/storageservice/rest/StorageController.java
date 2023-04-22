package dev.amir.storageservice.rest;

import dev.amir.storageservice.entity.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestController
@RequiredArgsConstructor
public class StorageController {

    private final StorageRepository storageRepository;

    @DeleteMapping("/storages")
    public ResponseEntity<DeleteStorageResponse> deleteAllByIdIn(@RequestParam("id") List<Long> ids) {
        var existingStorages = storageRepository.findAllByIdIn(ids);
        var existingStoragesIds = existingStorages.stream().map(Storage::getId).toList();
        storageRepository.deleteAllById(existingStoragesIds);
        return ResponseEntity.ok(new DeleteStorageResponse(existingStoragesIds));
    }
}

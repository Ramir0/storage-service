package dev.amir.storageservice.rest;

import dev.amir.storageservice.entity.Storage;
import dev.amir.storageservice.repository.StorageRepository;
import dev.amir.storageservice.rest.response.DeleteStorageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/storages")
public class StorageController {
    private final StorageRepository storageRepository;

    @PostMapping
    public ResponseEntity<Storage> saveStorage(@RequestBody Storage storage) {
        if (Objects.isNull(storage) || Objects.nonNull(storage.getId())) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Saving Storage: [{}]", storage);
        try {
            return ResponseEntity.ok(storageRepository.save(storage));
        } catch (Exception exception) {
            log.error("Storage was not saved", exception);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Storage>> getAllStorages() {
        log.info("Fetching all Storages");
        try {
            return ResponseEntity.ok(storageRepository.findAll());
        } catch (Exception exception) {
            log.error("Storages were not fetched", exception);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<DeleteStorageResponse> deleteAllByIdIn(@RequestParam("id") List<Long> ids) {
        log.info("Deleting Storages with ids: [{}]", ids);
        try {
            var existingStorages = storageRepository.findAllByIdIn(ids);
            var existingStoragesIds = existingStorages.stream().map(Storage::getId).toList();
            storageRepository.deleteAllById(existingStoragesIds);
            return ResponseEntity.ok(new DeleteStorageResponse(existingStoragesIds));
        } catch (Exception exception) {
            log.error("Storages were not deleted", exception);
            return ResponseEntity.internalServerError().build();
        }
    }
}

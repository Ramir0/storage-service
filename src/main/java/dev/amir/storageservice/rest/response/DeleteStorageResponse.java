package dev.amir.storageservice.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteStorageResponse {
    private Iterable<Long> ids;
}

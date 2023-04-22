CREATE TABLE storages
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    bucket       VARCHAR(255) NULL,
    path         VARCHAR(255) NULL,
    storage_type VARCHAR(255) NULL
);
CREATE TABLE users (
    id                BIGINT       NOT NULL AUTO_INCREMENT,
    keycloak_sub      VARCHAR(64)  NOT NULL,
    email             VARCHAR(255) NOT NULL,
    nickname          VARCHAR(100) NOT NULL,
    profile_image_url VARCHAR(500),
    role              VARCHAR(32)  NOT NULL DEFAULT 'USER',
    created_at        DATETIME(6)  NOT NULL,
    updated_at        DATETIME(6)  NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_users_keycloak_sub (keycloak_sub),
    UNIQUE KEY uk_users_email (email)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

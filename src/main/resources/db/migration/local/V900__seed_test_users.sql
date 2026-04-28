-- Seed users for local/dev. keycloak_sub uses placeholder values that match
-- test users created in Keycloak realm; update these after Keycloak realm import.
INSERT INTO users (keycloak_sub, email, nickname, profile_image_url, role, created_at, updated_at)
VALUES
    ('seed-test1', 'test1@ilovepawn.com', 'TestUser1', NULL, 'USER',  NOW(6), NOW(6)),
    ('seed-test2', 'test2@ilovepawn.com', 'TestUser2', NULL, 'USER',  NOW(6), NOW(6)),
    ('seed-admin', 'admin@ilovepawn.com', 'TestAdmin', NULL, 'ADMIN', NOW(6), NOW(6));

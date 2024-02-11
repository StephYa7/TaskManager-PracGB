CREATE TYPE enum_status AS ENUM ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED');

CREATE TABLE IF NOT EXISTS tasks
(
    id           bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    status       enum_status default 'NOT_STARTED',
    description  varchar NOT NULL,
    date_created date default now()
    );
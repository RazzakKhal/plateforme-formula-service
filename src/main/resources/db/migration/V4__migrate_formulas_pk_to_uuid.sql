CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS formula_id_map
(
    legacy_id BIGINT PRIMARY KEY,
    id        UUID NOT NULL UNIQUE
);

DO $$
BEGIN
    IF to_regclass('public.formulas') IS NULL THEN
        RETURN;
    END IF;

    IF EXISTS (
        SELECT 1
        FROM information_schema.columns
        WHERE table_schema = 'public'
          AND table_name = 'formulas'
          AND column_name = 'id'
          AND data_type <> 'uuid'
    ) THEN
        ALTER TABLE formulas ADD COLUMN IF NOT EXISTS new_id UUID;
        UPDATE formulas SET new_id = gen_random_uuid() WHERE new_id IS NULL;

        INSERT INTO formula_id_map (legacy_id, id)
        SELECT id::BIGINT, new_id
        FROM formulas
        ON CONFLICT (legacy_id) DO UPDATE SET id = EXCLUDED.id;

        ALTER TABLE formulas DROP CONSTRAINT IF EXISTS formula_pkey;
        ALTER TABLE formulas DROP CONSTRAINT IF EXISTS formulas_pkey;
        ALTER TABLE formulas DROP COLUMN id;
        ALTER TABLE formulas RENAME COLUMN new_id TO id;
        ALTER TABLE formulas ADD CONSTRAINT formulas_pkey PRIMARY KEY (id);
    END IF;
END $$;

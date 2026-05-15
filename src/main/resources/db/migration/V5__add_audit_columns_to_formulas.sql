ALTER TABLE IF EXISTS formulas ADD COLUMN IF NOT EXISTS created_by VARCHAR(255);
ALTER TABLE IF EXISTS formulas ADD COLUMN IF NOT EXISTS updated_by VARCHAR(255);
ALTER TABLE IF EXISTS formulas ADD COLUMN IF NOT EXISTS created_at TIMESTAMP;
ALTER TABLE IF EXISTS formulas ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP;

UPDATE formulas
SET created_by = COALESCE(created_by, 'system-migration'),
    created_at = COALESCE(created_at, NOW())
WHERE created_by IS NULL
   OR created_at IS NULL;

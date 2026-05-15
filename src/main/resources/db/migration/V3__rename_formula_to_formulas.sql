DO $$
BEGIN
    IF to_regclass('public.formula') IS NOT NULL
        AND to_regclass('public.formulas') IS NULL THEN
        ALTER TABLE formula RENAME TO formulas;
    END IF;
END $$;

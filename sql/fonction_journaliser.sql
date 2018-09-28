-- FUNCTION: public.copiercamp()

-- DROP FUNCTION public.copiercamp();

CREATE OR REPLACE FUNCTION public.copiercamp(
	)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 0
AS $BODY$

DECLARE
	moutonCourant RECORD;
BEGIN
	FOR moutonCourant IN
		select *, cast(ancienpoids as double precision) as bonpoids from mouton
    
    LOOP
    	UPDATE MOUTON set poids = moutonCourant.bonpoids WHERE id = moutonCourant.id;
        
    END LOOP;
END

$BODY$;

ALTER FUNCTION public.copiercamp()
    OWNER TO postgres;

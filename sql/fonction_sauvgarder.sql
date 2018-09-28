-- FUNCTION: public.sauvegarderchamp()

-- DROP FUNCTION public.sauvegarderchamp();

CREATE OR REPLACE FUNCTION public.sauvegarderchamp(
	)
    RETURNS void
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    AS $BODY$

DECLARE 

	skieurCourant RECORD;
	moyennePoidsSkieur integer;
	totalSkieur integer;
	checksum text;
	
BEGIN	

checksum:='';

	FOR skieurCourant IN 
    SELECT * from skieur 
    LOOP
		checksum:= checksum || skieurCourant.prenom || ', ' ;
	END LOOP; 
	
	select count(*) INTO totalSkieur from skieur ;
	select AVG(poids) INTO moyennePoidsSkieur from skieur;
	INSERT INTO surveillance_skieur (moment, "totalSkieur", "moyennePoidsSkieur", checksum) VALUES ( NOW(), totalSkieur, moyennePoidsSkieur, MD5(checksum));

END 
$BODY$;

ALTER FUNCTION public.sauvegarderchamp()
    OWNER TO postgres;

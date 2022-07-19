SELECT Ciudad, Clasificacion, COUNT(*) AS TOTAL, MIN(Fecha_Inicio) AS VIEJO, MAX(Fecha_Inicio) AS RECIENTE  
From Proyecto p 
WHERE Clasificacion  NOT IN ('Casa Campestre', 'Condominio')
GROUP BY Ciudad , Clasificacion 
ORDER BY Ciudad, Clasificacion ;

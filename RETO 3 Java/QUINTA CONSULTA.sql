SELECT L.Nombre ||' ' || L.Primer_Apellido || ' ' || L.Segundo_Apellido AS LIDER, SUM(C.Cantidad*MC.Precio_Unidad) as VALOR
FROM Lider L
Join Proyecto P on P.ID_Lider  = L.ID_Lider 
JOIN Compra C on P.ID_Proyecto  = C.ID_Proyecto 
JOIN MaterialConstruccion MC on C.ID_MaterialConstruccion  = MC.ID_MaterialConstruccion 
GROUP BY LIDER
ORDER BY VALOR DESC 
LIMIT 10;


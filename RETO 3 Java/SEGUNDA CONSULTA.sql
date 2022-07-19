SELECT P.ID_Proyecto as ID, P.Constructora, P.Ciudad, P.Clasificacion, T.Estrato, L.Nombre || ' ' || L.Primer_Apellido ||' '||L.Segundo_Apellido AS LIDER
FROM Proyecto P 
Join Tipo T  on (P.ID_Tipo = T.ID_Tipo)
JOIN Lider L on (P.ID_Lider = L.ID_Lider)
WHERE P.Banco_vinculado = 'Conavi'
ORDER BY Fecha_Inicio DESC , Ciudad , Constructora ;
SELECT P.ID_Proyecto , SUM(C.Cantidad*MC.Precio_Unidad) AS VALOR
FROM Proyecto P
JOIN Compra C on P.ID_Proyecto = C.ID_Proyecto 
JOIN MaterialConstruccion MC ON C.ID_MaterialConstruccion LIKE MC.ID_MaterialConstruccion  
WHERE C.Pagado LIKE 'No'
GROUP BY P.ID_Proyecto 
HAVING SUM (C.Cantidad*MC.Precio_Unidad) > 50000 
ORDER BY VALOR DESC ;
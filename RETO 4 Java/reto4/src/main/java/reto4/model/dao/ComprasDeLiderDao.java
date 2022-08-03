package reto4.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto4.util.JDBCUtilities;
import reto4.model.vo.ComprasDeLiderVo;

public class ComprasDeLiderDao {
    public List<ComprasDeLiderVo> listar() throws SQLException {
        ArrayList<ComprasDeLiderVo> respuesta = new ArrayList<ComprasDeLiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement pstmt = null;
        ResultSet rs = null;
        String consulta = "SELECT L.Nombre ||' ' || L.Primer_Apellido || ' ' || L.Segundo_Apellido AS LIDER,"
                + "SUM(C.Cantidad*MC.Precio_Unidad) as VALOR"
                + "FROM Lider L"
                + "Join Proyecto P on P.ID_Lider  = L.ID_Lider "
                + "JOIN Compra C on P.ID_Proyecto  = C.ID_Proyecto "
                + "JOIN MaterialConstruccion MC on C.ID_MaterialConstruccion  = MC.ID_MaterialConstruccion "
                + "GROUP BY LIDER"
                + "ORDER BY VALOR DESC"
                + "LIMIT 10";
        try {
            pstmt = conn.createStatement();
            rs = pstmt.executeQuery(consulta);

            while (rs.next()) {
                ComprasDeLiderVo objeto = new ComprasDeLiderVo();
                objeto.setLider(rs.getString("lider"));
                objeto.setValor(rs.getDouble("valor"));
                respuesta.add(objeto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}

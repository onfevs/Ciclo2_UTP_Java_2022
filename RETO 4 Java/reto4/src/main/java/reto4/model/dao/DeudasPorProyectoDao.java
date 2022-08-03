package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto4.model.vo.DeudasPorProyectoVo;
import reto4.util.JDBCUtilities;

public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar(Double limite) throws SQLException {
        ArrayList<DeudasPorProyectoVo> respuesta = new ArrayList<DeudasPorProyectoVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String consulta = "SELECT P.ID_Proyecto , SUM(C.Cantidad*MC.Precio_Unidad) AS VALOR"
                + "FROM Proyecto P"
                + "JOIN Compra C on P.ID_Proyecto = C.ID_Proyecto"
                + "JOIN MaterialConstruccion MC ON C.ID_MaterialConstruccion LIKE MC.ID_MaterialConstruccion"
                + "WHERE C.Pagado LIKE 'No'"
                + "GROUP BY P.ID_Proyecto"
                + "HAVING SUM (C.Cantidad*MC.Precio_Unidad) > ?"
                + "ORDER BY VALOR DESC ";
        try {
            pstmt = conn.prepareStatement(consulta);
            pstmt.setDouble(1, limite);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                DeudasPorProyectoVo objeto = new DeudasPorProyectoVo();
                objeto.setId(rs.getInt("id"));
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

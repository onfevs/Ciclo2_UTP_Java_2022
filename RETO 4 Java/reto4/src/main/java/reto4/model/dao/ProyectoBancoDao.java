package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto4.model.vo.ProyectoBancoVo;
import reto4.util.JDBCUtilities;

public class ProyectoBancoDao {
    public List<ProyectoBancoVo> listar(String banco) throws SQLException {
        ArrayList<ProyectoBancoVo> respuesta = new ArrayList<ProyectoBancoVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String consulta = "SELECT P.ID_Proyecto as ID, P.Constructora, P.Ciudad, P.Clasificacion, T.Estrato, L.Nombre || ' ' || L.Primer_Apellido ||' '||L.Segundo_Apellido AS LIDER"
                + "FROM Proyecto P "
                + "Join Tipo T  on (P.ID_Tipo = T.ID_Tipo)"
                + "JOIN Lider L on (P.ID_Lider = L.ID_Lider)"
                + "WHERE P.Banco_vinculado = ?"
                + "ORDER BY Fecha_Inicio DESC , Ciudad , Constructora";
        try {
            pstmt = conn.prepareStatement(consulta);
            pstmt.setString(1, banco);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProyectoBancoVo objeto = new ProyectoBancoVo();
                objeto.setId(rs.getInt("id"));
                objeto.setConstructora(rs.getString("constructora"));
                objeto.setCiudad(rs.getString("ciudad"));
                objeto.setClasificacion(rs.getString("clasificacion"));
                objeto.setEstrato(rs.getInt("estrato"));
                objeto.setLider(rs.getString("lider"));
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

package reto4.controller;

import reto4.model.vo.ComprasDeLiderVo;
import reto4.model.vo.ProyectoBancoVo;
import reto4.model.vo.DeudasPorProyectoVo;

import java.sql.SQLException;
import java.util.List;

import reto4.model.dao.ComprasDeLiderDao;
import reto4.model.dao.ProyectoBancoDao;
import reto4.model.dao.DeudasPorProyectoDao;

public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;

    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public List<ProyectoBancoVo> listaTotalProyectoBanco(String banco) throws SQLException {
        return proyectoBancoDao.listar(banco);
    }

    public List<DeudasPorProyectoVo> listaTotalDeudasPorProyecto(Double limite) throws SQLException {
        return deudasPorProyectoDao.listar(limite);
    }

    public List<ComprasDeLiderVo> listaTotalComprasDeLider() throws SQLException {
        return comprasDeLiderDao.listar();
    }
}

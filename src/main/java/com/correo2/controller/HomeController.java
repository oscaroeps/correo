package com.correo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.correo2.entity.Correo;
import com.correo2.entity.TipoCorreo;
import com.correo2.service.CorreoService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Controller
public class HomeController {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private DataSource dataSource;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listaCorreos", correoService.obtenerTodos());
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevoRegistro(Model model) {
        model.addAttribute("accion", "Nuevo");
        model.addAttribute("correo", new Correo());
        model.addAttribute("listaTipos", obtenerListaTipos());
        return "form";
    }
    
    private List<TipoCorreo> obtenerListaTipos() {
        List<TipoCorreo> lista = new ArrayList<>();
        lista.add(new TipoCorreo(1, "Personal"));
        lista.add(new TipoCorreo(2, "Laboral"));
        lista.add(new TipoCorreo(3, "Otro"));
        return lista;
    }

    @PostMapping("/guardar")
    public String guardarRegistro(@ModelAttribute("correo") Correo correo) {
        correoService.guardar(correo);
        return "redirect:/";
    }

    @GetMapping("/editar")
    public String editarRegistro(@RequestParam("id") int id, Model model) {
        Correo correo = correoService.obtenerPorId(id);
        if (correo == null) {
            return "redirect:/";
        }
        model.addAttribute("accion", "Editar");
        model.addAttribute("correo", correo);
        model.addAttribute("listaTipos", obtenerListaTipos());
        return "form";
    }

    @PostMapping("/actualizar")
    public String actualizarRegistro(@ModelAttribute("correo") Correo correo) {
        correoService.actualizar(correo);
        return "redirect:/";
    }

    @GetMapping("/eliminar")
    public String eliminarRegistro(@RequestParam("id") int id) {
        correoService.eliminar(id);
        return "redirect:/";
    }

    @GetMapping("/reporte")
    public void descargarReporte(HttpServletResponse response) {
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=ReporteCorreos.pdf");

            InputStream reportStream = getClass().getResourceAsStream("/reports/reporte1.jasper");
            if (reportStream == null) {
                throw new RuntimeException("No se encontró el reporte en /reports/reporte1.jasper");
            }

            Properties props = new Properties();
            InputStream propStream = getClass().getResourceAsStream("/query.properties");
            props.load(propStream);
            String query = props.getProperty("reporte.query");
            propStream.close();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("QUERY", query);

            Connection conn = dataSource.getConnection();

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, conn);

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
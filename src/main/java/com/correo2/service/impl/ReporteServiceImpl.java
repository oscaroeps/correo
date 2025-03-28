package com.correo2.service.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.correo2.service.ReporteService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private DataSource dataSource;

    @Override
    public byte[] generarReporteCorreos() throws Exception {
        InputStream reportStream = this.getClass().getResourceAsStream("/reports/reporte1.jasper");
        if (reportStream == null) {
            throw new RuntimeException("No se encontró el reporte en /reports/reporte1.jasper");
        }

        Map<String, Object> parameters = new HashMap<>();

        try (Connection conn = dataSource.getConnection()) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, conn);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        }
    }
}

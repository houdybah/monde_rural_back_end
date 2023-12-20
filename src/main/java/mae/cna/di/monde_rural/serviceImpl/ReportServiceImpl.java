package mae.cna.di.monde_rural.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.config.Constant;
import mae.cna.di.monde_rural.dto.ReportDto;
import mae.cna.di.monde_rural.dto.ReportResultDto;
import mae.cna.di.monde_rural.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@Service
public class ReportServiceImpl implements ReportService{

	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ResourceLoader resourceLoader;

	@Override
	public ReportResultDto createReport(ReportDto report) throws SQLException {
		try 
		{
			Resource resource = resourceLoader.getResource("classpath:/reports/"+report.getName()+".jasper");
			InputStream reportStream = resource.getInputStream();
			Map parameters = new HashMap();
			ReportResultDto reportResult = new ReportResultDto();
			parameters.put("REPORT_FOLDER", resource.getFile().getAbsolutePath());
			
			Connection conn = this.dataSource.getConnection();
			byte[] reportBytes = JasperRunManager.runReportToPdf(reportStream, parameters, conn);
			reportResult.setName(report.getName()+"_"+System.currentTimeMillis()+".pdf");
			FileOutputStream fileOutPutStream = new FileOutputStream(Constant.REPORT_RESULT_FOLDER+reportResult.getName());
			fileOutPutStream.write(reportBytes);
			fileOutPutStream.close();
			return reportResult;
		}
		catch(JRException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}

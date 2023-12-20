package mae.cna.di.monde_rural.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mae.cna.di.monde_rural.dto.ReportDto;
import mae.cna.di.monde_rural.dto.ReportResultDto;
import mae.cna.di.monde_rural.service.ReportService;



@CrossOrigin
@RestController
public class ReportController {
    
    @Autowired
    private ReportService reportService;
    
    Logger logger = LoggerFactory.getLogger(ReportController.class);

    @PostMapping("/print")
    public ReportResultDto uploadFile(@RequestBody ReportDto report) {
    	
//    	logger.info("\n\n{}\n\n",report.getName());
    	
		ReportResultDto reportResult = null;
		try 
		{
			reportResult = this.reportService.createReport(report);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return reportResult;
     
    }

}

package mae.cna.di.monde_rural.service;

import java.sql.SQLException;

import mae.cna.di.monde_rural.dto.ReportDto;
import mae.cna.di.monde_rural.dto.ReportResultDto;

public interface ReportService {
	
	public ReportResultDto createReport(ReportDto report) throws SQLException;
	
}

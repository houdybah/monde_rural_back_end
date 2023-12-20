package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.DomainesCooperativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface DomaineCooperativeService {

	DomainesCooperativeDto save(DomainesCooperativeDto domainesCooperativeDto);

	DomainesCooperativeDto update(DomainesCooperativeDto domainesCooperativeDto, String uuid);

	DomainesCooperativeDto getOne(String uuid);

	PageDataDto<DomainesCooperativeDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

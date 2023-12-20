package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.DomaineDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface DomaineService {

	DomaineDto save(DomaineDto domaineDto);

	DomaineDto update(DomaineDto domaineDto, String uuid);

	DomaineDto getOne(String uuid);

	PageDataDto<DomaineDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

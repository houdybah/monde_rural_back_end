package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.EspeceDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface EspeceService {

	EspeceDto save(EspeceDto especeDto);

	EspeceDto update(EspeceDto especeDto, String uuid);

	EspeceDto getOne(String uuid);

	PageDataDto<EspeceDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

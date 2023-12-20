package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.CooperativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface CooperativeService {

	CooperativeDto save(CooperativeDto cooperativeDto);

	CooperativeDto update(CooperativeDto cooperativeDto, String uuid);

	CooperativeDto getOne(String uuid);

	PageDataDto<CooperativeDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

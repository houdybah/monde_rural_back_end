package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.RaceFamilleDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface RaceFamilleService {

	RaceFamilleDto save(RaceFamilleDto raceFamilleDto);

	RaceFamilleDto update(RaceFamilleDto raceFamilleDto, String uuid);

	RaceFamilleDto getOne(String uuid);

	PageDataDto<RaceFamilleDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

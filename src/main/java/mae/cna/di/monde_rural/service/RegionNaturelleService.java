package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.RegionNaturelleDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface RegionNaturelleService {

	RegionNaturelleDto save(RegionNaturelleDto regionNaturelleDto);

	RegionNaturelleDto update(RegionNaturelleDto regionNaturelleDto, String uuid);

	RegionNaturelleDto getOne(String uuid);

	PageDataDto<RegionNaturelleDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

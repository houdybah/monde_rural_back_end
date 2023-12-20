package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.RegionAdministrativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface RegionAdministrativeService {

	RegionAdministrativeDto save(RegionAdministrativeDto regionAdministrativeDto);

	RegionAdministrativeDto update(RegionAdministrativeDto regionAdministrativeDto, String uuid);

	RegionAdministrativeDto getOne(String uuid);

	PageDataDto<RegionAdministrativeDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

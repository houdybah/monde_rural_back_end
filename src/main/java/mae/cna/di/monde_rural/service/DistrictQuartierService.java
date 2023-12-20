package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.DistrictQuartierDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface DistrictQuartierService {

	DistrictQuartierDto save(DistrictQuartierDto districtQuartierDto);

	DistrictQuartierDto update(DistrictQuartierDto districtQuartierDto, String uuid);

	DistrictQuartierDto getOne(String uuid);

	PageDataDto<DistrictQuartierDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

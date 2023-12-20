package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.ChambreDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface ChambreService {

	ChambreDto save(ChambreDto chambreDto);

	ChambreDto update(ChambreDto chambreDto, String uuid);

	ChambreDto getOne(String uuid);

	PageDataDto<ChambreDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

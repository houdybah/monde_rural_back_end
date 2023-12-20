package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.VillageSecteurDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface VillageSecteurService {

	VillageSecteurDto save(VillageSecteurDto cooperativeDto);

	VillageSecteurDto update(VillageSecteurDto cooperativeDto, String uuid);

	VillageSecteurDto getOne(String uuid);

	PageDataDto<VillageSecteurDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

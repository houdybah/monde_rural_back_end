package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.MembreEtProducteurDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface MembreEtProducteurService {

	MembreEtProducteurDto save(MembreEtProducteurDto membreEtProducteurDto);

	MembreEtProducteurDto update(MembreEtProducteurDto membreEtProducteurDto, String uuid);

	MembreEtProducteurDto getOne(String uuid);

	PageDataDto<MembreEtProducteurDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.TypeDomaineDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface TypeDomaineService {

	TypeDomaineDto save(TypeDomaineDto typeDomaineDto);

	TypeDomaineDto update(TypeDomaineDto typeDomaineDto, String uuid);

	TypeDomaineDto getOne(String uuid);

	PageDataDto<TypeDomaineDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

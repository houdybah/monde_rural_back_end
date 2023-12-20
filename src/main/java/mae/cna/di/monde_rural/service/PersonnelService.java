package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.PersonnelDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface PersonnelService {

	PersonnelDto save(PersonnelDto personnelDto);

	PersonnelDto update(PersonnelDto personnelDto, String uuid);

	PersonnelDto getOne(String uuid);

	PageDataDto<PersonnelDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.LieuDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface LieuService {

	LieuDto save(LieuDto lieuDto);

	LieuDto update(LieuDto lieuDto, String uuid);

	LieuDto getOne(String uuid);

	PageDataDto<LieuDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

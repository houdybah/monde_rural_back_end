package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.PrefectureDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface PrefectureService {

	PrefectureDto save(PrefectureDto prefectureDto);

	PrefectureDto update(PrefectureDto prefectureDto, String uuid);

	PrefectureDto getOne(String uuid);

	PageDataDto<PrefectureDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

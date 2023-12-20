package mae.cna.di.monde_rural.service;

import mae.cna.di.monde_rural.dto.SousPrefectureDto;
import mae.cna.di.monde_rural.dto.PageDataDto;

public interface SousPrefectureService {

	SousPrefectureDto save(SousPrefectureDto sousPrefectureDto);

	SousPrefectureDto update(SousPrefectureDto sousPrefectureDto, String uuid);

	SousPrefectureDto getOne(String uuid);

	PageDataDto<SousPrefectureDto> getAllKeyedAndOrPageed(String key, int page, int size);

	void delete(String uuid);
	
}

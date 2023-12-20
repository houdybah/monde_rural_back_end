package mae.cna.di.monde_rural.serviceImpl;

import mae.cna.di.monde_rural.dto.RaceFamilleDto;
import mae.cna.di.monde_rural.exception.EspeceNotFoundException;
import mae.cna.di.monde_rural.exception.RaceFamilleAlreadyExistException;
import mae.cna.di.monde_rural.exception.RaceFamilleIsFatherException;
import mae.cna.di.monde_rural.exception.RaceFamilleNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.EspeceRepository;
import mae.cna.di.monde_rural.repository.RaceFamilleRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Espece;
import mae.cna.di.monde_rural.domain.RaceFamille;
import mae.cna.di.monde_rural.dto.RaceFamilleDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.RaceFamilleService;
import mae.cna.di.monde_rural.service.RaceFamilleService;

@Service
public class RaceFamilleServiceImpl implements RaceFamilleService{

	@Autowired
	RaceFamilleRepository raceFamilleRepository;
	
	@Autowired
	EspeceRepository especeRepository;
	
	@Override
	public RaceFamilleDto save(RaceFamilleDto raceFamilleDto) {
		
		RaceFamille raceFamille = new RaceFamille();
		Espece espece = especeRepository.findById(raceFamilleDto.getEspeceUuid()).orElseThrow(() -> new EspeceNotFoundException(raceFamilleDto.getEspeceUuid()));
		
		raceFamille.setCode(raceFamilleDto.getCode());
		raceFamille.setDescription(raceFamilleDto.getDescription());
		raceFamille.setLibelle(raceFamilleDto.getLibelle());
		raceFamille.setEspece(espece);
		
		RaceFamille raceFamilleSaved = new RaceFamille();
		
		try {
			raceFamilleSaved = raceFamilleRepository.save(raceFamille);
		} catch (Exception e) {
			throw new RaceFamilleAlreadyExistException();
		}
		
		return Mapper.toRaceFamilleDto(raceFamilleSaved);
	}

	@Override
	public RaceFamilleDto update(RaceFamilleDto raceFamilleDto, String uuid) {
		RaceFamille raceFamille = raceFamilleRepository.findById(uuid).orElseThrow(() -> new RaceFamilleNotFoundException(uuid));
		Espece espece = especeRepository.findById(raceFamilleDto.getEspeceUuid()).orElseThrow(() -> new EspeceNotFoundException(raceFamilleDto.getEspeceUuid()));
		
		raceFamille.setCode(raceFamilleDto.getCode());
		raceFamille.setDescription(raceFamilleDto.getDescription());
		raceFamille.setLibelle(raceFamilleDto.getLibelle());
		raceFamille.setEspece(espece);
		
		
		raceFamille = raceFamilleRepository.save(raceFamille);
		
		return Mapper.toRaceFamilleDto(raceFamille);
	}

	@Override
	public RaceFamilleDto getOne(String uuid) {
		RaceFamille raceFamille = raceFamilleRepository.findById(uuid).orElseThrow(() -> new RaceFamilleNotFoundException(uuid));
		return Mapper.toRaceFamilleDto(raceFamille);
	}

	@Override
	public PageDataDto<RaceFamilleDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<RaceFamilleDto> pageData = new PageDataDto<RaceFamilleDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<RaceFamille> listRaceFamille = null;
		
		if(key == null)
		{
			listRaceFamille = raceFamilleRepository.findAll(pageable);
		}
		else
		{
			listRaceFamille = raceFamilleRepository.findAllKeyed(pageable, key);
		}
		
		final List<RaceFamilleDto> listRaceFamilleDto = new ArrayList<RaceFamilleDto>();
		listRaceFamille.forEach(raceFamille -> {
			listRaceFamilleDto.add(Mapper.toRaceFamilleDto(raceFamille));
		});
		
		pageData.setData(listRaceFamilleDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listRaceFamille.getTotalElements());
		pageData.getPage().setTotalPages(listRaceFamille.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			raceFamilleRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new RaceFamilleIsFatherException(uuid);
		}
		
	}
	
}

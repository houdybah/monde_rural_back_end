package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Domaine;
import mae.cna.di.monde_rural.domain.Espece;
import mae.cna.di.monde_rural.dto.EspeceDto;
import mae.cna.di.monde_rural.dto.EspeceDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.DomaineNotFoundException;
import mae.cna.di.monde_rural.exception.EspeceAlreadyExistException;
import mae.cna.di.monde_rural.exception.EspeceIsFatherException;
import mae.cna.di.monde_rural.exception.EspeceNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.DomaineRepository;
import mae.cna.di.monde_rural.repository.EspeceRepository;
import mae.cna.di.monde_rural.service.EspeceService;
import mae.cna.di.monde_rural.service.EspeceService;

@Service
public class EspeceServiceImpl implements EspeceService{

	@Autowired
	EspeceRepository especeRepository;
	
	@Autowired
	DomaineRepository domaineRepository;
	
	@Override
	public EspeceDto save(EspeceDto especeDto) {
		
		Espece espece = new Espece();
		Domaine domaine = domaineRepository.findById(especeDto.getDomaineUuid()).orElseThrow(() -> new DomaineNotFoundException(especeDto.getDomaineUuid()));
		
		espece.setCode(especeDto.getCode());
		espece.setDescription(especeDto.getDescription());
		espece.setLibelle(especeDto.getLibelle());
		espece.setDomaine(domaine);
		
		Espece especeSaved = new Espece();
		
		try {
			especeSaved = especeRepository.save(espece);
		} catch (Exception e) {
			throw new EspeceAlreadyExistException();
		}
		
		return Mapper.toEspeceDto(especeSaved);
	}

	@Override
	public EspeceDto update(EspeceDto especeDto, String uuid) {
		
		Espece espece = especeRepository.findById(uuid).orElseThrow(() -> new EspeceNotFoundException(uuid));
		Domaine domaine = domaineRepository.findById(especeDto.getDomaineUuid()).orElseThrow(() -> new DomaineNotFoundException(especeDto.getDomaineUuid()));
		espece.setDomaine(domaine);
		
		espece.setCode(especeDto.getCode());
		espece.setDescription(especeDto.getDescription());
		espece.setLibelle(especeDto.getLibelle());
		
		espece = especeRepository.save(espece);
		
		return Mapper.toEspeceDto(espece);
	}

	@Override
	public EspeceDto getOne(String uuid) {
		Espece espece = especeRepository.findById(uuid).orElseThrow(() -> new EspeceNotFoundException(uuid));
		return Mapper.toEspeceDto(espece);
	}

	@Override
	public PageDataDto<EspeceDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<EspeceDto> pageData = new PageDataDto<EspeceDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Espece> listEspece = null;
		
		if(key == null)
		{
			listEspece = especeRepository.findAll(pageable);
		}
		else
		{
			listEspece = especeRepository.findAllKeyed(pageable, key);
		}
		
		final List<EspeceDto> listEspeceDto = new ArrayList<EspeceDto>();
		listEspece.forEach(espece -> {
			listEspeceDto.add(Mapper.toEspeceDto(espece));
		});
		
		pageData.setData(listEspeceDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listEspece.getTotalElements());
		pageData.getPage().setTotalPages(listEspece.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			especeRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new EspeceIsFatherException(uuid);
		}
		
	}

	
	
}

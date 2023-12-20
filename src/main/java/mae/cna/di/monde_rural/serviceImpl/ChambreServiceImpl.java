package mae.cna.di.monde_rural.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.dto.ChambreDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.ChambreAlreadyExistException;
import mae.cna.di.monde_rural.exception.ChambreIsFatherException;
import mae.cna.di.monde_rural.exception.ChambreNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.ChambreRepository;
import mae.cna.di.monde_rural.service.ChambreService;

@Service
public class ChambreServiceImpl implements ChambreService{

	@Autowired
	ChambreRepository chambreRepository;
	
	@Override
	public ChambreDto save(ChambreDto chambreDto) {
		
		Chambre chambre = new Chambre();
		
		chambre.setCode(chambreDto.getCode());
		chambre.setDescription(chambreDto.getDescription());
		chambre.setLibelle(chambreDto.getLibelle());
		
		Chambre chambreSaved = new Chambre();
		
		try {
			chambreSaved = chambreRepository.save(chambre);
		} catch (Exception e) {
			throw new ChambreAlreadyExistException();
		}
		
		return Mapper.toChambreDto(chambreSaved);
	}

	@Override
	public ChambreDto update(ChambreDto chambreDto, String uuid) {
		Chambre chambre = chambreRepository.findById(uuid).orElseThrow(() -> new ChambreNotFoundException(uuid));
		
		chambre.setCode(chambreDto.getCode());
		chambre.setDescription(chambreDto.getDescription());
		chambre.setLibelle(chambreDto.getLibelle());
		
		chambre = chambreRepository.save(chambre);
		
		return Mapper.toChambreDto(chambre);
	}

	@Override
	public ChambreDto getOne(String uuid) {
		Chambre chambre = chambreRepository.findById(uuid).orElseThrow(() -> new ChambreNotFoundException(uuid));
		return Mapper.toChambreDto(chambre);
	}

	@Override
	public PageDataDto<ChambreDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<ChambreDto> pageData = new PageDataDto<ChambreDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Chambre> listChambre = null;
		
		if(key == null)
		{
			listChambre = chambreRepository.findAll(pageable);
		}
		else
		{
			listChambre = chambreRepository.findAllKeyed(pageable, key);
		}
		
		final List<ChambreDto> listChambreDto = new ArrayList<ChambreDto>();
		listChambre.forEach(chambre -> {
			listChambreDto.add(Mapper.toChambreDto(chambre));
		});
		
		pageData.setData(listChambreDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listChambre.getTotalElements());
		pageData.getPage().setTotalPages(listChambre.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			chambreRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new ChambreIsFatherException(uuid);
		}
		
	}

}

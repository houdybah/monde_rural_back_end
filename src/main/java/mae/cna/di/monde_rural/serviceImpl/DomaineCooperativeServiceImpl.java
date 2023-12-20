package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Cooperative;
import mae.cna.di.monde_rural.domain.Domaine;
import mae.cna.di.monde_rural.domain.DomainesCooperative;
import mae.cna.di.monde_rural.dto.DomainesCooperativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.CooperativeNotFoundException;
import mae.cna.di.monde_rural.exception.DomaineCooperativeAlreadyExistException;
import mae.cna.di.monde_rural.exception.DomaineCooperativeIsFatherException;
import mae.cna.di.monde_rural.exception.DomaineCooperativeNotFoundException;
import mae.cna.di.monde_rural.exception.DomaineNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.CooperativeRepository;
import mae.cna.di.monde_rural.repository.DomaineRepository;
import mae.cna.di.monde_rural.repository.DomainesCooperativeRepository;
import mae.cna.di.monde_rural.service.DomaineCooperativeService;

@Service
public class DomaineCooperativeServiceImpl implements DomaineCooperativeService{


	@Autowired
	DomainesCooperativeRepository domainesCooperativeRepository;
	
	@Autowired
	DomaineRepository domaineRepository;
	
	@Autowired
	CooperativeRepository cooperativeRepository;
	
	@Override
	public DomainesCooperativeDto save(DomainesCooperativeDto domainesCooperativeDto) {
		
		DomainesCooperative domainesCooperative = new DomainesCooperative();
		
		Domaine domaine = domaineRepository.findById(domainesCooperativeDto.getDomaineUuid()).orElseThrow(() -> new DomaineNotFoundException(domainesCooperativeDto.getDomaineUuid()));
		Cooperative cooperative = cooperativeRepository.findById(domainesCooperativeDto.getCooperativeUuid()).orElseThrow(() -> new CooperativeNotFoundException(domainesCooperativeDto.getCooperativeUuid()));
		domainesCooperative.setDateDebut(domainesCooperativeDto.getDateDebut());
		domainesCooperative.setDateFin(null);
		domainesCooperative.setActivites(domainesCooperativeDto.getActivites());
		domainesCooperative.setCooperative(cooperative);
		domainesCooperative.setDomaine(domaine);
		
		DomainesCooperative domainesCooperativeSaved = new DomainesCooperative();
		
		try {
			domainesCooperativeSaved = domainesCooperativeRepository.save(domainesCooperative);
		} catch (Exception e) {
			throw new DomaineCooperativeAlreadyExistException();
		}
		
		return Mapper.toDomainesCooperativeDto(domainesCooperativeSaved);
	}

	@Override
	public DomainesCooperativeDto update(DomainesCooperativeDto domainesCooperativeDto, String uuid) {
		
		DomainesCooperative domainesCooperative = domainesCooperativeRepository.findById(uuid).orElseThrow(() -> new DomaineCooperativeNotFoundException(uuid));
		
		Domaine domaine = domaineRepository.findById(domainesCooperativeDto.getDomaineUuid()).orElseThrow(() -> new DomaineNotFoundException(domainesCooperativeDto.getDomaineUuid()));
		Cooperative cooperative = cooperativeRepository.findById(domainesCooperativeDto.getCooperativeUuid()).orElseThrow(() -> new CooperativeNotFoundException(domainesCooperativeDto.getCooperativeUuid()));
		domainesCooperative.setDateDebut(domainesCooperativeDto.getDateDebut());
		domainesCooperative.setDateFin(null);
		domainesCooperative.setActivites(domainesCooperativeDto.getActivites());
		domainesCooperative.setCooperative(cooperative);
		domainesCooperative.setDomaine(domaine);
		
		domainesCooperative = domainesCooperativeRepository.save(domainesCooperative);
		
		return Mapper.toDomainesCooperativeDto(domainesCooperative);
	}

	@Override
	public DomainesCooperativeDto getOne(String uuid) {
		
		DomainesCooperative domainesCooperative = domainesCooperativeRepository.findById(uuid).orElseThrow(() -> new DomaineCooperativeNotFoundException(uuid));
		return Mapper.toDomainesCooperativeDto(domainesCooperative);
	}

	@Override
	public PageDataDto<DomainesCooperativeDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<DomainesCooperativeDto> pageData = new PageDataDto<DomainesCooperativeDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<DomainesCooperative> listDomainesCooperative = null;
		
		if(key == null)
		{
			listDomainesCooperative = domainesCooperativeRepository.findAll(pageable);
		}
		else
		{
			listDomainesCooperative = domainesCooperativeRepository.findAllKeyed(pageable, key);
		}
		
		final List<DomainesCooperativeDto> listDomainesCooperativeDto = new ArrayList<DomainesCooperativeDto>();
		listDomainesCooperative.forEach(domainesCooperative -> {
			listDomainesCooperativeDto.add(Mapper.toDomainesCooperativeDto(domainesCooperative));
		});
		
		pageData.setData(listDomainesCooperativeDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listDomainesCooperative.getTotalElements());
		pageData.getPage().setTotalPages(listDomainesCooperative.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			domainesCooperativeRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new DomaineCooperativeIsFatherException(uuid);
		}
		
	}

	
}

package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Lieu;
import mae.cna.di.monde_rural.domain.VillageSecteur;
import mae.cna.di.monde_rural.dto.LieuDto;
import mae.cna.di.monde_rural.dto.LieuDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.LieuAlreadyExistException;
import mae.cna.di.monde_rural.exception.LieuIsFatherException;
import mae.cna.di.monde_rural.exception.LieuNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.LieuRepository;
import mae.cna.di.monde_rural.repository.VillageSecteurRepository;
import mae.cna.di.monde_rural.service.LieuService;
import mae.cna.di.monde_rural.service.LieuService;

@Service
public class LieuServiceImpl implements LieuService{

	@Autowired
	LieuRepository lieuRepository;
	
	@Autowired
	VillageSecteurRepository villageSecteurRepository;
	
	@Override
	public LieuDto save(LieuDto lieuDto) {
		
		Lieu lieu = new Lieu();
		VillageSecteur villageSecteur = villageSecteurRepository.findById(lieuDto.getVillageSecteurUuid()).orElseThrow(() -> new LieuNotFoundException(lieuDto.getVillageSecteurUuid()));
		
		lieu.setLongitude(lieuDto.getLongitude());
		lieu.setDescription(lieuDto.getDescription());
		lieu.setLatitude(lieuDto.getLatitude());
		lieu.setVillageSecteur(villageSecteur);
		
		Lieu lieuSaved = new Lieu();
		
		try {
			lieuSaved = lieuRepository.save(lieu);
		} catch (Exception e) {
			throw new LieuAlreadyExistException();
		}
		
		return Mapper.toLieuDto(lieuSaved);
	}

	@Override
	public LieuDto update(LieuDto lieuDto, String uuid) {
		Lieu lieu = lieuRepository.findById(uuid).orElseThrow(() -> new LieuNotFoundException(uuid));
		
VillageSecteur villageSecteur = villageSecteurRepository.findById(lieuDto.getVillageSecteurUuid()).orElseThrow(() -> new LieuNotFoundException(lieuDto.getVillageSecteurUuid()));
		
		lieu.setLongitude(lieuDto.getLongitude());
		lieu.setDescription(lieuDto.getDescription());
		lieu.setLatitude(lieuDto.getLatitude());
		lieu.setVillageSecteur(villageSecteur);
		
		lieu = lieuRepository.save(lieu);
		
		return Mapper.toLieuDto(lieu);
	}

	@Override
	public LieuDto getOne(String uuid) {
		Lieu lieu = lieuRepository.findById(uuid).orElseThrow(() -> new LieuNotFoundException(uuid));
		return Mapper.toLieuDto(lieu);
	}

	@Override
	public PageDataDto<LieuDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<LieuDto> pageData = new PageDataDto<LieuDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Lieu> listLieu = null;
		
		if(key == null)
		{
			listLieu = lieuRepository.findAll(pageable);
		}
		else
		{
			listLieu = lieuRepository.findAllKeyed(pageable, key);
		}
		
		final List<LieuDto> listLieuDto = new ArrayList<LieuDto>();
		listLieu.forEach(lieu -> {
			listLieuDto.add(Mapper.toLieuDto(lieu));
		});
		
		pageData.setData(listLieuDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listLieu.getTotalElements());
		pageData.getPage().setTotalPages(listLieu.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			lieuRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new LieuIsFatherException(uuid);
		}
		
	}

	
	
}

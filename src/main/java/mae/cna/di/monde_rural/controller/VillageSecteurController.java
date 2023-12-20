
package mae.cna.di.monde_rural.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mae.cna.di.monde_rural.dto.VillageSecteurDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.VillageSecteurService;

@RestController
public class VillageSecteurController {
	
	@Autowired
	private VillageSecteurService villageSecteurService; 
	
	@PostMapping("/villageSecteur") 
	public VillageSecteurDto save(@RequestBody VillageSecteurDto villageSecteurDto) {
		return villageSecteurService.save(villageSecteurDto);	
	}
	
	@PutMapping("/villageSecteur/{uuid}")
	public VillageSecteurDto update(@RequestBody  VillageSecteurDto villageSecteurDto,@PathVariable String uuid) {
		return villageSecteurService.update(villageSecteurDto, uuid);
	}   
	
	@GetMapping("/villageSecteur/{uuid}") 
	public VillageSecteurDto findById(@PathVariable String uuid) {
		return villageSecteurService.getOne(uuid);
	}
	
	
	@GetMapping("/villageSecteur")
    public PageDataDto<VillageSecteurDto> getAllWithKeyAndPage(
    		@PathVariable String uuidVillageSecteur,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return villageSecteurService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/villageSecteur/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		villageSecteurService.delete(uuid);
	}
}

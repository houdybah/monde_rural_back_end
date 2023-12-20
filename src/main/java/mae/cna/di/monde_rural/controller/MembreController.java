
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

import mae.cna.di.monde_rural.dto.MembreEtProducteurDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.MembreEtProducteurService;

@RestController
public class MembreController {
	
	@Autowired
	private MembreEtProducteurService membreEtProducteurService; 
	
	@PostMapping("/membreEtProducteur") 
	public MembreEtProducteurDto save(@RequestBody MembreEtProducteurDto membreEtProducteurDto) {
		return membreEtProducteurService.save(membreEtProducteurDto);	
	}
	
	@PutMapping("/membreEtProducteur/{uuid}")
	public MembreEtProducteurDto update(@RequestBody  MembreEtProducteurDto membreEtProducteurDto,@PathVariable String uuid) {
		return membreEtProducteurService.update(membreEtProducteurDto, uuid);
	}   
	
	@GetMapping("/membreEtProducteur/{uuid}") 
	public MembreEtProducteurDto findById(@PathVariable String uuid) {
		return membreEtProducteurService.getOne(uuid);
	}
	
	
	@GetMapping("/membreEtProducteur")
    public PageDataDto<MembreEtProducteurDto> getAllWithKeyAndPage(
    		@PathVariable String uuidMembreEtProducteur,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return membreEtProducteurService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/membreEtProducteur/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		membreEtProducteurService.delete(uuid);
	}
}

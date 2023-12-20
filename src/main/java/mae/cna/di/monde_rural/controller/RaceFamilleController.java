
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

import mae.cna.di.monde_rural.dto.RaceFamilleDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.RaceFamilleService;

@RestController
public class RaceFamilleController {
	
	@Autowired
	private RaceFamilleService raceFamilleService; 
	
	@PostMapping("/raceFamille") 
	public RaceFamilleDto save(@RequestBody RaceFamilleDto raceFamilleDto) {
		return raceFamilleService.save(raceFamilleDto);	
	}
	
	@PutMapping("/raceFamille/{uuid}")
	public RaceFamilleDto update(@RequestBody  RaceFamilleDto raceFamilleDto,@PathVariable String uuid) {
		return raceFamilleService.update(raceFamilleDto, uuid);
	}   
	
	@GetMapping("/raceFamille/{uuid}") 
	public RaceFamilleDto findById(@PathVariable String uuid) {
		return raceFamilleService.getOne(uuid);
	}
	
	
	@GetMapping("/raceFamille")
    public PageDataDto<RaceFamilleDto> getAllWithKeyAndPage(
    		@PathVariable String uuidRaceFamille,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return raceFamilleService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/raceFamille/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		raceFamilleService.delete(uuid);
	}
}


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

import mae.cna.di.monde_rural.dto.RegionNaturelleDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.RegionNaturelleService;

@RestController
public class RegionNaturelleController {
	
	@Autowired
	private RegionNaturelleService regionNaturelleService; 
	
	@PostMapping("/regionNaturelle") 
	public RegionNaturelleDto save(@RequestBody RegionNaturelleDto regionNaturelleDto) {
		return regionNaturelleService.save(regionNaturelleDto);	
	}
	
	@PutMapping("/regionNaturelle/{uuid}")
	public RegionNaturelleDto update(@RequestBody  RegionNaturelleDto regionNaturelleDto,@PathVariable String uuid) {
		return regionNaturelleService.update(regionNaturelleDto, uuid);
	}   
	
	@GetMapping("/regionNaturelle/{uuid}") 
	public RegionNaturelleDto findById(@PathVariable String uuid) {
		return regionNaturelleService.getOne(uuid);
	}
	
	
	@GetMapping("/regionNaturelle")
    public PageDataDto<RegionNaturelleDto> getAllWithKeyAndPage(
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return regionNaturelleService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/regionNaturelle/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		regionNaturelleService.delete(uuid);
	}
}

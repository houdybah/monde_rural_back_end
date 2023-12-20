
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

import mae.cna.di.monde_rural.dto.RegionAdministrativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.RegionAdministrativeService;

@RestController
public class RegionAdministrativeController {
	
	@Autowired
	private RegionAdministrativeService regionAdministrativeService; 
	
	@PostMapping("/regionAdministrative") 
	public RegionAdministrativeDto save(@RequestBody RegionAdministrativeDto regionAdministrativeDto) {
		return regionAdministrativeService.save(regionAdministrativeDto);	
	}
	
	@PutMapping("/regionAdministrative/{uuid}")
	public RegionAdministrativeDto update(@RequestBody  RegionAdministrativeDto regionAdministrativeDto,@PathVariable String uuid) {
		return regionAdministrativeService.update(regionAdministrativeDto, uuid);
	}   
	
	@GetMapping("/regionAdministrative/{uuid}") 
	public RegionAdministrativeDto findById(@PathVariable String uuid) {
		return regionAdministrativeService.getOne(uuid);
	}
	
	
	@GetMapping("/regionAdministrative")
    public PageDataDto<RegionAdministrativeDto> getAllWithKeyAndPage(
    		@PathVariable String uuidRegionAdministrative,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return regionAdministrativeService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/regionAdministrative/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		regionAdministrativeService.delete(uuid);
	}
}

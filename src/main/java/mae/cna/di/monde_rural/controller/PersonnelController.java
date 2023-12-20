
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

import mae.cna.di.monde_rural.dto.PersonnelDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.PersonnelService;

@RestController
public class PersonnelController {
	
	@Autowired
	private PersonnelService personnelService; 
	
	@PostMapping("/personnel") 
	public PersonnelDto save(@RequestBody PersonnelDto personnelDto) {
		return personnelService.save(personnelDto);	
	}
	
	@PutMapping("/personnel/{uuid}")
	public PersonnelDto update(@RequestBody  PersonnelDto personnelDto,@PathVariable String uuid) {
		return personnelService.update(personnelDto, uuid);
	}   
	
	@GetMapping("/personnel/{uuid}") 
	public PersonnelDto findById(@PathVariable String uuid) {
		return personnelService.getOne(uuid);
	}
	
	
	@GetMapping("/personnel")
    public PageDataDto<PersonnelDto> getAllWithKeyAndPage(
    		@PathVariable String uuidPersonnel,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return personnelService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/personnel/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		personnelService.delete(uuid);
	}
}

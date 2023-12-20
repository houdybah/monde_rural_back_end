
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

import mae.cna.di.monde_rural.dto.DomaineDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.DomaineService;

@RestController
public class DomaineController {
	
	@Autowired
	private DomaineService domaineService; 
	
	@PostMapping("/domaine") 
	public DomaineDto save(@RequestBody DomaineDto domaineDto) {
		return domaineService.save(domaineDto);	
	}
	
	@PutMapping("/domaine/{uuid}")
	public DomaineDto update(@RequestBody  DomaineDto domaineDto,@PathVariable String uuid) {
		return domaineService.update(domaineDto, uuid);
	}   
	
	@GetMapping("/domaine/{uuid}") 
	public DomaineDto findById(@PathVariable String uuid) {
		return domaineService.getOne(uuid);
	}
	
	
	@GetMapping("/domaine")
    public PageDataDto<DomaineDto> getAllWithKeyAndPage(
    		@PathVariable String uuidDomaine,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return domaineService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/domaine/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		domaineService.delete(uuid);
	}
}

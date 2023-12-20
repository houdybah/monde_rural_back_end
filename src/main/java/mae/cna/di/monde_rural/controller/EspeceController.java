
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

import mae.cna.di.monde_rural.dto.EspeceDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.EspeceService;

@RestController
public class EspeceController {
	
	@Autowired
	private EspeceService especeService; 
	
	@PostMapping("/espece") 
	public EspeceDto save(@RequestBody EspeceDto especeDto) {
		return especeService.save(especeDto);	
	}
	
	@PutMapping("/espece/{uuid}")
	public EspeceDto update(@RequestBody  EspeceDto especeDto,@PathVariable String uuid) {
		return especeService.update(especeDto, uuid);
	}   
	
	@GetMapping("/espece/{uuid}") 
	public EspeceDto findById(@PathVariable String uuid) {
		return especeService.getOne(uuid);
	}
	
	
	@GetMapping("/espece")
    public PageDataDto<EspeceDto> getAllWithKeyAndPage(
    		@PathVariable String uuidEspece,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return especeService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/espece/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		especeService.delete(uuid);
	}
}

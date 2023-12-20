
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

import mae.cna.di.monde_rural.dto.TypeDomaineDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.TypeDomaineService;

@RestController
public class TypeDomaineController {
	
	@Autowired
	private TypeDomaineService typeDomaineService; 
	
	@PostMapping("/typeDomaine") 
	public TypeDomaineDto save(@RequestBody TypeDomaineDto typeDomaineDto) {
		return typeDomaineService.save(typeDomaineDto);	
	}
	
	@PutMapping("/typeDomaine/{uuid}")
	public TypeDomaineDto update(@RequestBody  TypeDomaineDto typeDomaineDto,@PathVariable String uuid) {
		return typeDomaineService.update(typeDomaineDto, uuid);
	}   
	
	@GetMapping("/typeDomaine/{uuid}") 
	public TypeDomaineDto findById(@PathVariable String uuid) {
		return typeDomaineService.getOne(uuid);
	}
	
	
	@GetMapping("/typeDomaine")
    public PageDataDto<TypeDomaineDto> getAllWithKeyAndPage(
    		@PathVariable String uuidTypeDomaine,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return typeDomaineService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/typeDomaine/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		typeDomaineService.delete(uuid);
	}
}


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

import mae.cna.di.monde_rural.dto.PrefectureDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.PrefectureService;

@RestController
public class PrefectureController {
	
	@Autowired
	private PrefectureService prefectureService; 
	
	@PostMapping("/prefecture") 
	public PrefectureDto save(@RequestBody PrefectureDto prefectureDto) {
		return prefectureService.save(prefectureDto);	
	}
	
	@PutMapping("/prefecture/{uuid}")
	public PrefectureDto update(@RequestBody  PrefectureDto prefectureDto,@PathVariable String uuid) {
		return prefectureService.update(prefectureDto, uuid);
	}   
	
	@GetMapping("/prefecture/{uuid}") 
	public PrefectureDto findById(@PathVariable String uuid) {
		return prefectureService.getOne(uuid);
	}
	
	
	@GetMapping("/prefecture")
    public PageDataDto<PrefectureDto> getAllWithKeyAndPage(
    		@PathVariable String uuidPrefecture,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return prefectureService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/prefecture/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		prefectureService.delete(uuid);
	}
}

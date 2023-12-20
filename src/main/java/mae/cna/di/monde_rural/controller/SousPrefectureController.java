
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

import mae.cna.di.monde_rural.dto.SousPrefectureDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.SousPrefectureService;

@RestController
public class SousPrefectureController {
	
	@Autowired
	private SousPrefectureService sousPrefectureService; 
	
	@PostMapping("/sousPrefecture") 
	public SousPrefectureDto save(@RequestBody SousPrefectureDto sousPrefectureDto) {
		return sousPrefectureService.save(sousPrefectureDto);	
	}
	
	@PutMapping("/sousPrefecture/{uuid}")
	public SousPrefectureDto update(@RequestBody  SousPrefectureDto sousPrefectureDto,@PathVariable String uuid) {
		return sousPrefectureService.update(sousPrefectureDto, uuid);
	}   
	
	@GetMapping("/sousPrefecture/{uuid}") 
	public SousPrefectureDto findById(@PathVariable String uuid) {
		return sousPrefectureService.getOne(uuid);
	}
	
	
	@GetMapping("/sousPrefecture")
    public PageDataDto<SousPrefectureDto> getAllWithKeyAndPage(
    		@PathVariable String uuidSousPrefecture,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return sousPrefectureService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/sousPrefecture/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		sousPrefectureService.delete(uuid);
	}
}

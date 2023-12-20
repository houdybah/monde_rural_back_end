package mae.cna.di.monde_rural.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mae.cna.di.monde_rural.domain.StoredFile;
import mae.cna.di.monde_rural.dto.StoredFileDto;
import mae.cna.di.monde_rural.dto.StoredFileInfoDto;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.service.StoredFileService;
import mae.cna.di.monde_rural.serviceImpl.StoredFileServiceImpl;

//@CrossOrigin(origins = "*")
@RestController
@CrossOrigin
public class FileController {

    
    @Autowired
    private StoredFileService storageService;
    
    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload")
    public ResponseEntity<StoredFileInfoDto> uploadFile(@RequestParam("file") MultipartFile file) {
      String message = "";
      logger.info("file: {}",file);
      try {
          StoredFile sotredFile =  storageService.store(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(Mapper.toStoredFileInfoDto(sotredFile));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
      }
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<StoredFileDto> getFileById(@PathVariable String id) {
        StoredFile fileDB = storageService.getFileById(id);

      return ResponseEntity.ok()
//          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
          .body(Mapper.toStoreFileDto(fileDB));
    }
    
}

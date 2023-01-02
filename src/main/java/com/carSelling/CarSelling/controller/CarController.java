package com.carSelling.CarSelling.controller;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carSelling.CarSelling.entity.Car;
import com.carSelling.CarSelling.entity.CarData;
import com.carSelling.CarSelling.entity.TrendCar;
import com.carSelling.CarSelling.repository.CarRepository;
import com.carSelling.CarSelling.service.CarService;
import com.carSelling.CarSelling.service.JoinQueryService;
import com.carSelling.CarSelling.service.StorageService;


@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService carService;
	@Autowired
	JoinQueryService joinQueryService;
	
	  @Autowired
	    CarRepository carRepository;
	  
	@Autowired
	StorageService storageService;
	
	@GetMapping("/carList")
	public Object getCars() {
		List<Car> carLists = carService.getAll();
		if(carLists.size() > 0) {
			return carLists;
		} else {
			return "There is no car list";
		}

	}
	
	@GetMapping("/{car_id}")
	public ResponseEntity<Car> getCar(
			@PathVariable("car_id") int carId
	) {
		Car car = carService.get(carId);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(car);
	}
	
	@GetMapping("/CarDetailsList")
	public ResponseEntity<List<CarData>> getCarDetailLists() {
		return new ResponseEntity<List<CarData>>(joinQueryService.getCarDetailLists(), HttpStatus.OK);
	}
	
	@GetMapping("/trend")
	public ResponseEntity<List<TrendCar>> getTrendCarLists() {
		return new ResponseEntity<List<TrendCar>>(joinQueryService.getTrendCarLists(), HttpStatus.OK);
	}
	@GetMapping("/brand")
	public ResponseEntity<List<TrendCar>> getBrandCarLists() {
		return new ResponseEntity<List<TrendCar>>(joinQueryService.getBrandCarLists(), HttpStatus.OK);
	}
	@GetMapping("/used")
	public ResponseEntity<List<TrendCar>> getUsedCarLists() {
		return new ResponseEntity<List<TrendCar>>(joinQueryService.getUsedCarLists(), HttpStatus.OK);
	}
	
	@GetMapping("/discount")
	public ResponseEntity<List<TrendCar>> getDiscountCarLists() {
		return new ResponseEntity<List<TrendCar>>(joinQueryService.getDiscountCarLists(), HttpStatus.OK);
	}
	
//	public Object getCarDetails() {
//		List<CarDetails> carLists = carService.join();
//		if(carLists.size() > 0) {
//			return carLists;
//		} else {
//			return "There is no car list";
//		}
//
//	}
//	
	
//    @GetMapping("/carDetails/{id}")
//    public String index(@PathVariable("id")Integer id, Model model) {
//
//        List<Car> list2 =carRepository.find(id);
//        model.addAttribute("lists2", list2);
//
//
//        return "index";
//    }
//	
    
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Car> createCategory(@RequestBody Car car){
		Car newCar=carService.create(car);
		return new ResponseEntity<Car>(newCar,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Car> updateCar(
			@PathVariable int id, @Valid @RequestBody Car car
	) {
		Car updateCar = carService.update(id, car);
		if (updateCar == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(updateCar);
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable int id) {
		Car car = carService.get(id);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		String imagePath = car.getImagePath();
		boolean isDeleted = carService.delete(id);
		if (!isDeleted) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		storageService.delete(imagePath);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/file/create")
	public String createFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType
	) {
		String fileName = storageService.create(file, fileType);
		return fileName;
	}
	
	@PutMapping("/file/update")
	public String updateFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType,
			@RequestParam("filePath") String filePath
	) {
		String fileName = storageService.update(file, fileType, filePath);
		return fileName;
	}
	
	@GetMapping("/media/{fileType}/{fileName}")
	public ResponseEntity<?> getPoster(
			@PathVariable("fileType") String fileType,
			@PathVariable("fileName") String fileName
	) throws IOException {
		MediaType contentType = MediaType.IMAGE_PNG;
		switch (fileType) {
			case "mp4" :
				contentType = MediaType.APPLICATION_OCTET_STREAM;
				break;
			case "jpg" :
				contentType = MediaType.IMAGE_JPEG;
				break;
			case "png" :
				contentType = MediaType.IMAGE_PNG;
				break;
			default :
				return ResponseEntity.badRequest()
						.body("Unsupported File Type");
		}
		byte[] fileBytes = storageService.load(fileName);
		if (fileBytes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().contentType(contentType).body(fileBytes);
	}

	
}

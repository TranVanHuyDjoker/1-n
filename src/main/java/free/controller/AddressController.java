package free.controller;

import free.controller.dto.request.AddressRequest;
import free.controller.dto.response.AddressResponse;
import free.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/getAllAddress")
    ResponseEntity<?> getAddress(){
        List<AddressResponse> responses = addressService.getAddress();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/insert")
    ResponseEntity<?> insertAddress(@Validated @RequestBody AddressRequest request){
        addressService.insertAddress(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    ResponseEntity<?> updateAddress(@Validated @RequestBody AddressRequest request){
        addressService.updateAddress(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.ok().build();
    }


}

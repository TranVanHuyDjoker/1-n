package free.controller;

import free.controller.dto.request.NXBRequest;
import free.controller.dto.response.NXBResponse;
import free.service.NXBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/nxb")
public class NXBController {

    private final NXBService nxbService;

    @GetMapping("/getAllNXB")
    ResponseEntity<?> getNXB(){
        List<NXBResponse> responses = nxbService.getNXB();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/insert")
    ResponseEntity<?> insertNXB(@RequestBody NXBRequest nxbRequest){
        nxbService.insertNXB(nxbRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    ResponseEntity<?> updateNXB(@RequestBody NXBRequest nxbRequest){
        nxbService.updateNXB(nxbRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteNXB(@PathVariable Long id){
        nxbService.deleteNXB(id);
        return ResponseEntity.ok().build();
    }
}

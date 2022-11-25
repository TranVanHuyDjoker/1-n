package free.controller;

import free.controller.dto.request.MemberRequest;
import free.controller.dto.response.MemberResponse;
import free.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/getAllMember")
    ResponseEntity<?> getMember(){
        List<MemberResponse> memberResponses = memberService.getMember();
        return ResponseEntity.ok(memberResponses);
    }

    @PostMapping("/insert")
    ResponseEntity<?> insertNXB( @Validated @RequestBody MemberRequest request, @RequestParam Long id){
        memberService.insertMember(request, id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    ResponseEntity<?> updateNXB( @Validated @RequestBody MemberRequest request, @RequestParam Long id){
        memberService.updateMember(request, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteNXB(@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }

}

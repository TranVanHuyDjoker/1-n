package free.service.impl;

import free.controller.dto.request.MemberRequest;
import free.controller.dto.response.MemberResponse;
import free.entity.Address;
import free.entity.Member;
import free.repository.AddressRepository;
import free.repository.MemberRepository;
import free.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<MemberResponse> getMember() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public void insertMember(MemberRequest request, Long id) {
        boolean flag = memberRepository.existsMemberByEmail(request.getEmail());
        if (flag){
            throw new RuntimeException("mail da ton tai");
        }

        Address address = addressRepository.findById(id).orElseThrow(()-> new RuntimeException("k tim thay id address"));

        Member member = new Member();
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        member.setPassword(request.getPassword());
        member.setAddress(address);
        memberRepository.save(member);
    }

    @Override
    public void updateMember(MemberRequest request, Long id) {
        Member member = memberRepository.findById(request.getId()).orElseThrow(()->new RuntimeException("k thay id"));
        Set<String> emails = memberRepository.findAll()
                .stream().map(Member::getEmail)
                .collect(Collectors.toSet());
        if(emails.contains(request.getEmail()) && !Objects.equals(request.getEmail(), member.getEmail())){
            throw new RuntimeException("mail da ton tai");
        }

        Address address = addressRepository.findById(id).orElseThrow(()-> new RuntimeException("k tim thay id address"));
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        member.setPassword(request.getPassword());
        member.setAddress(address);
        memberRepository.save(member);

    }

    @Override
    public void deleteMember(Long id) {
        boolean flag = memberRepository.existsMemberById(id);
        if (!flag){
            throw  new RuntimeException("id k ton tai");
        }
        memberRepository.deleteById(id);
    }
}

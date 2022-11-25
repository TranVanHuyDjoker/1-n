package free.service;

import free.controller.dto.request.MemberRequest;
import free.controller.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {
    List<MemberResponse> getMember();

    void insertMember(MemberRequest request, Long id);

    void updateMember(MemberRequest request, Long id);

    void deleteMember(Long id);
}

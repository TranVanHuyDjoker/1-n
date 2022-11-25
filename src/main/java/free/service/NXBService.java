package free.service;

import free.controller.dto.request.NXBRequest;
import free.controller.dto.response.NXBResponse;

import java.util.List;

public interface NXBService {
    List<NXBResponse> getNXB();

    void insertNXB(NXBRequest request);

    void updateNXB(NXBRequest request);

    void deleteNXB(Long id);


}

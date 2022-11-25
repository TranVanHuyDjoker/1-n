package free.service.impl;

import free.controller.dto.request.NXBRequest;
import free.controller.dto.response.NXBResponse;
import free.entity.NXB;
import free.repository.NXBRepository;
import free.service.NXBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NXBServiceImpl implements NXBService {

    @Autowired
    private NXBRepository nxbRepository;

    @Override
    public List<NXBResponse> getNXB() {
        return nxbRepository.findAll()
                .stream()
                .map(NXBResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public void insertNXB(NXBRequest request) {
        boolean flag = nxbRepository.existsNXBByName(request.getName());
        if (flag) {
            throw new RuntimeException("ten da ton tai");

        }
        NXB nxb = fromDTO(request);
        nxbRepository.save(nxb);
    }

    private NXB fromDTO(NXBRequest request) {
        NXB nxb = new NXB();
        nxb.setName(request.getName());
        nxb.setAddress(request.getAddress());

        return nxb;
    }

    @Override
    public void updateNXB(NXBRequest request) {
        NXB nxb = new NXB();
        nxb = nxbRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("k thay id"));
        Set<String> names = nxbRepository.findAll()
                .stream()
                .map(NXB::getName)
                .collect(Collectors.toSet());
        if (names.contains(request.getName()) && !Objects.equals(request.getName(), nxb.getName())){
            throw new RuntimeException("names da co");
        }
        nxb.setName(request.getName());
        nxb.setAddress(request.getAddress());
        nxbRepository.save(nxb);
    }

    @Override
    public void deleteNXB(Long id) {
        boolean flag = nxbRepository.existsNXBById(id);
        if (!flag) {
            throw new RuntimeException("id k ton tai");
        }
        nxbRepository.deleteById(id);

    }
}

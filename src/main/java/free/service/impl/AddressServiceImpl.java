package free.service.impl;

import free.controller.dto.request.AddressRequest;
import free.controller.dto.response.AddressResponse;
import free.entity.Address;
import free.repository.AddressRepository;
import free.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressResponse> getAddress() {
        return addressRepository.findAll()
                .stream()
                .map(AddressResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public void insertAddress(AddressRequest request) {
        boolean flag = addressRepository.existsAddressByName(request.getName());
        if (flag) {
            throw new RuntimeException("name dax ton tai");
        }

        Address address = new Address();
        address.setName(request.getName());
        address.setCity(request.getCity());
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(AddressRequest request) {
        Address address = addressRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("id k ton tai"));
        Set<String> names = addressRepository.findAll()
                .stream()
                .map(Address::getName)
                .collect(Collectors.toSet());
        if (names.contains(request.getName()) && !Objects.equals(request.getName(), address.getName())){
            throw new RuntimeException("names da ton tai");
        }
        address.setName(request.getName());
        address.setCity(request.getCity());
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        boolean flag = addressRepository.existsAddressById(id);
        if (!flag) {
            throw new RuntimeException("id k ton tai");
        }
        addressRepository.deleteById(id);
    }
}

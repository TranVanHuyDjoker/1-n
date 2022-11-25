package free.service;

import free.controller.dto.request.AddressRequest;
import free.controller.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddress();

    void insertAddress(AddressRequest request);

    void updateAddress(AddressRequest request);

    void deleteAddress(Long id);

}

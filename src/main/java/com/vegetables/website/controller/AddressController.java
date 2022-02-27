package com.vegetables.website.controller;

import com.vegetables.website.dao.AddressDAO;
import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.Address;
import com.vegetables.website.model.AddressRequest;
import com.vegetables.website.model.ApplicationUser;
import com.vegetables.website.model.AuthenticationRequest;
import com.vegetables.website.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/addresses", method = { RequestMethod.GET, RequestMethod.POST})
public class AddressController {
    private final AddressDAO addressDAO;
    private final ApplicationUserDAO applicationUserDAO;

    public AddressController(AddressDAO addressDAO, ApplicationUserDAO applicationUserDAO) {
        this.addressDAO = addressDAO;
        this.applicationUserDAO = applicationUserDAO;
    }

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("")
    public Iterable<Address> getAddresses() {
        return addressDAO.findAll();
    }

    @GetMapping("/{address_id}")
    public Optional<Address> getAddress(@PathVariable(value = "address_id") Long address_id) {
        return addressDAO.findById(address_id);
    }

    @PostMapping("/entry")
    public void writeAddress(AddressRequest addressRequest, @RequestHeader Map<String, String> headers) throws Exception {
        Address address = new Address();
        address.setAddressLineOne(addressRequest.getAddressLineOne());
        address.setAddressLineTwo(addressRequest.getAddressLineTwo());
        address.setCity(addressRequest.getCity());
        address.setCounty(addressRequest.getCounty());
        address.setPostcode(addressRequest.getPostcode());

        String[] cookie = headers.get("cookie").split("jwt-token=");
        String email = jwtUtil.extractUsername(cookie[1]);
        ApplicationUser user = applicationUserDAO.findByEmail(email);
        address.setWebUserId(user.getId());

        addressDAO.save(address);
    }
}

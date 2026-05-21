package com.estudo.java.spring.CompaninVTR.Controller.AuthController;

import com.estudo.java.spring.CompaninVTR.DTO.auhtDTO.LoginRequestDTO;
import com.estudo.java.spring.CompaninVTR.DTO.auhtDTO.LoginResponseDTO;
import com.estudo.java.spring.CompaninVTR.Infra.TokenService;
import com.estudo.java.spring.CompaninVTR.Model.User;
import com.estudo.java.spring.CompaninVTR.Repository.IEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IEntityRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Validated LoginRequestDTO dto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generetedToken((User)auth.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token));
    }
}

package com.exam.onlineExam.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.onlineExam.Configuration.JwtUtils;
import com.exam.onlineExam.Entities.JwtRequest;
import com.exam.onlineExam.Entities.JwtResposne;
import com.exam.onlineExam.Services.ServiceImp.UserDetailsServiceImp;
import com.exam.onlineExam.Services.ServiceImp.userServiceImp;

@RestController
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
    {
        System.out.println(jwtRequest.getUsername()+" "+jwtRequest.getPassword());
        try{
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }
        catch(UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User nto fournd");
        }
        UserDetails userDetails=userDetailsServiceImp.loadUserByUsername(jwtRequest.getUsername());
        String token =jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResposne(token));
    }

    private void authenticate(String username ,String password) throws Exception
    {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        }
        catch(DisabledException e)
        {
            throw new Exception("User Disabled "+e.getMessage());
        }
        catch(BadCredentialsException e)
        {
            throw new Exception("Invallid Credent "+ e.getMessage());
        }
    }
}

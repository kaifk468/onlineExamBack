package com.exam.onlineExam.Configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticaionFilter  extends OncePerRequestFilter{

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        final String requestTokenHeader=request.getHeader("Authorization");

        //System.out.println(requestTokenHeader);
        String userName=null;
        String jwtToken=null;
        //System.out.println(requestTokenHeader+" is our tokenheader"+ requestTokenHeader.startsWith("Bearer "));
        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken=requestTokenHeader.substring(7);
            try{
                userName=this.jwtUtils.extractUsername(jwtToken);
            }
            catch(ExpiredJwtException e)
            {
                e.printStackTrace();
                System.out.println("jwt token is already expired");
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("Invalid Token,Not start with bearer");
            }
        }
        if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            final UserDetails userDetails=this.userDetailsService.loadUserByUsername(userName);
            if(jwtUtils.validateToken(jwtToken, userDetails))
            {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        else
        {
            System.out.println("token is not valid kaif");
        }
        filterChain.doFilter(request,response);
     
    }
    
}

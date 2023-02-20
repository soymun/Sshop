package com.example.shop.Controllers;

import com.example.shop.DTO.Security.RoleDto;
import com.example.shop.DTO.User.UserUpdateDto;
import com.example.shop.Response.ResponseDto;
import com.example.shop.Service.Imp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImp userServiceImp;

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('BUY')")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(ResponseDto.builder().data(userServiceImp.getUserById(id)).build());
    }

    @PatchMapping("/user")
    @PreAuthorize("hasAuthority('BUY')")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateDto userUpdateDto){
        if(userUpdateDto.getRole() != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(ResponseDto.builder().data(userServiceImp.updateUser(userUpdateDto)).build());
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasAuthority('BUY')")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        userServiceImp.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/user/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> regSelman(@PathVariable Long id, @RequestBody RoleDto role){
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setId(id);
        userUpdateDto.setRole(role.getRole());
        return ResponseEntity.ok(ResponseDto.builder().data(userServiceImp.updateUser(userUpdateDto)).build());
    }
}

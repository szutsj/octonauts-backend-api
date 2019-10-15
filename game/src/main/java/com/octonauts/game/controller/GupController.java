package com.octonauts.game.controller;

import com.octonauts.game.model.dto.GupListDTO;
import com.octonauts.game.model.dto.PatinentListDTO;
import com.octonauts.game.model.entity.Octopod;
import com.octonauts.game.model.entity.User;
import com.octonauts.game.repository.OctopodRepository;
import com.octonauts.game.service.GupService;
import com.octonauts.game.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GupController {

    private GupService gupService;
    private UserService userService;
    private OctopodRepository octopodRepository;

    @Autowired
    public GupController(GupService gupService, UserService userService, OctopodRepository octopodRepository) {
        this.gupService = gupService;
        this.userService = userService;
        this.octopodRepository = octopodRepository;
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "Authorization token",
            required = true, dataType = "string", paramType = "header")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = GupListDTO.class)})
    @GetMapping("/octopod/gups")
    public ResponseEntity<Object> gupList() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByName(username).get();
        Octopod octopod = octopodRepository.findByUser(user).get();
        GupListDTO gupListDTO = gupService.createGupList(octopod);
        return ResponseEntity.status(200).body(gupListDTO);
    }

}

package com.igot.cb.community.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.igot.cb.community.service.CommunityManagementService;
import com.igot.cb.pores.util.ApiResponse;
import com.igot.cb.pores.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mahesh.vakkund
 */
@RestController
@RequestMapping("/community/v1")
public class CommunityController {
    @Autowired
    private CommunityManagementService communityManagementService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody JsonNode communityDetails,
                                              @RequestHeader(Constants.X_AUTH_TOKEN) String authToken) {
        ApiResponse response = communityManagementService.create(communityDetails, authToken);
        return new ResponseEntity<>(response, response.getResponseCode());
    }

    @GetMapping("/read/{communityId}")
    public ResponseEntity<ApiResponse> read(@PathVariable String communityId,
                                            @RequestHeader(Constants.X_AUTH_TOKEN) String authToken) {
        ApiResponse response = communityManagementService.read(communityId, authToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{communityId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable String communityId,
                                              @RequestHeader(Constants.X_AUTH_TOKEN) String authToken) {
        ApiResponse response = communityManagementService.delete(communityId, authToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update(@RequestBody JsonNode communityDetails,
                                              @RequestHeader(Constants.X_AUTH_TOKEN) String authToken) {
        ApiResponse response = communityManagementService.update(communityDetails, authToken);
        return new ResponseEntity<>(response, response.getResponseCode());
    }
}

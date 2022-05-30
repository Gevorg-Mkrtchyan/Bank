package com.example.bank.cotroller;

import com.example.bank.domain.entity.Issuer;
import com.example.bank.service.IssuerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api
public class IssuerController {
    @Autowired
    private IssuerService issuerService;

    @GetMapping("/issuers/{id}")
    @ApiOperation("get issuer by id")
    public Issuer getById(@PathVariable("id") Long id) {
        return issuerService.getById(id);
    }

    @GetMapping("/issuers")
    @ApiOperation("get all issuers")
    public List<Issuer> getAll(Issuer issuer) {
        return issuerService.getAll(issuer);
    }

    @PostMapping("/issuers")
    @ApiOperation("create issuer")
    public Issuer create(@Valid @RequestBody Issuer issuer) {
        return issuerService.create(issuer);
    }

    @PutMapping("/issuers")
    @ApiOperation("update issuer")
    public Issuer update(@Valid @RequestBody Issuer issuer) {
        return issuerService.update(issuer);
    }

    @DeleteMapping("/issuers/{id}")
    @ApiOperation("delete issuer by id")
    public void delete(@PathVariable("id") Long id) {
        issuerService.delete(id);
    }
}

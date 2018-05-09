package com.gtdollar.gtserver.controller;


import com.gtdollar.gtserver.aop.LogInterceptor;
import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/")
public class AccountController {

    private static Logger log = Logger.getLogger( AccountController.class );
    @Autowired
    AccountService accountService;
     
    @Autowired
    MessageSource messageSource;


    /*
     * This method will provide the medium to add a new Account.
     */
    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestBody Account account ) {


        Map<String, Object> map = new HashMap<String, Object>();
        try {

            accountService.saveAccount(account);

            log.info( "2: " + account );
            map.put("success", new Boolean(true) );

            return new ResponseEntity<Map<String, Object>>( map, HttpStatus.OK);

        } catch ( Exception e ) {

            e.printStackTrace();
            map.put("success", new Boolean(false) );
            map.put("msg", e.getMessage() );
            return new ResponseEntity<Map<String, Object>>( map, HttpStatus.INTERNAL_SERVER_ERROR );
        }


    }

    @RequestMapping(value = { "/enquiry" }, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> findByEmail(@RequestBody Account account ) {

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Account findAcount = accountService.findByEmail( account.getEmail() );

            log.info( "2: " + findAcount );

            if( findAcount == null ) {
                throw new Exception("Can not find account " + account.getEmail() );
            }
            map.put("success", new Boolean(true) );
            map.put("balance", findAcount.getBalance() );

            return new ResponseEntity<Map<String, Object>>( map, HttpStatus.OK);
        } catch ( Exception e ) {

            e.printStackTrace();
            map.put("success", new Boolean( false ) );
            map.put("msg", e.getMessage() );
            return new ResponseEntity<Map<String, Object>>( map, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }
 
}
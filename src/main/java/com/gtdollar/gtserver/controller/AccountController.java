package com.gtdollar.gtserver.controller;


import com.gtdollar.gtserver.bean.JsonResponseBean;
import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AccountController {
 
    @Autowired
    AccountService accountService;
     
    @Autowired
    MessageSource messageSource;

    public static BigDecimal initBalance = new BigDecimal("10000");

    /*
     * This method will provide the medium to add a new Account.
     */
    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBean> create(@RequestBody Account account ) {

        System.out.println( "1: " + account );

        account.setCreateTime( new Date() );
        account.setBalance( initBalance );

        accountService.saveAccount( account );

        System.out.println( "2: " + account );

        JsonResponseBean jsonResponseBean = new JsonResponseBean( true, account.getBalance());


        return new ResponseEntity<JsonResponseBean>( jsonResponseBean, HttpStatus.OK);
    }

    @RequestMapping(value = { "/enquiry" }, method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBean> findByEmail(@RequestBody Account account ) {

        System.out.println( "1: " + account );

        Account findAcount = accountService.findByEmail( account.getEmail() );

        System.out.println( "2: " + findAcount );

        JsonResponseBean jsonResponseBean = new JsonResponseBean( true, findAcount.getBalance());

        System.out.println( "3: " + jsonResponseBean );

        return new ResponseEntity<JsonResponseBean>( jsonResponseBean, HttpStatus.OK);
    }
 
}
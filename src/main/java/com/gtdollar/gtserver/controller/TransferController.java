package com.gtdollar.gtserver.controller;


import com.gtdollar.gtserver.bean.JsonResponseBean;
import com.gtdollar.gtserver.bean.TransferRequestJson;
import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;
import com.gtdollar.gtserver.service.AccountService;
import com.gtdollar.gtserver.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/transfer")
public class TransferController {
 
    @Autowired
    AccountService accountService;

    @Autowired
    TransferService transferService;
     
    @Autowired
    MessageSource messageSource;

    public static BigDecimal initBalance = new BigDecimal("10000");

    /*
     * This method will provide the medium to add new Transfer.
     */
    @RequestMapping(value = { "/transfer" }, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestBody TransferRequestJson transferRequestJson ) {

        System.out.println( "1: " + transferRequestJson );

        Map<String, Object> map = null;
        Transfer transfer = new Transfer();

        transferRequestJson.toTransfer( transfer );

        transferService.saveTransfer( transfer );

        map = new HashMap<String, Object>();
        map.put("success", "true");

        return new ResponseEntity<Map<String, Object>>( map, HttpStatus.OK);
    }

    @RequestMapping(value = { "/enquiry" }, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> findByEmail(@RequestBody TransferRequestJson transferRequestJson ) {

        System.out.println( "1: " + transferRequestJson );
        Map<String, Object> map = null;

        Account findAcount = accountService.findByEmail( transferRequestJson.getEmail() );

        System.out.println( "2: " + findAcount );

        map = new HashMap<String, Object>();
        map.put("success", "true");
        map.put("transactions", findAcount.getTransferList() );

        System.out.println( "3: " + map );

        return new ResponseEntity<Map<String, Object>>( map, HttpStatus.OK);
    }


}
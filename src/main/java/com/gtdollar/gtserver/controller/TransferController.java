package com.gtdollar.gtserver.controller;


import com.gtdollar.gtserver.bean.TransferRequestJson;
import com.gtdollar.gtserver.bean.Utility;
import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;
import com.gtdollar.gtserver.service.AccountService;
import com.gtdollar.gtserver.service.TransferService;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    private static Logger log = Logger.getLogger( TransferController.class );

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

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Transfer transfer = new Transfer();

            transfer = transferRequestJson.toTransfer( transfer );

            transferService.saveTransfer( transfer );

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
    public ResponseEntity<Map<String, Object>> findByEmail(@RequestBody TransferRequestJson transferRequestJson ) {

        log.info( "1: " + transferRequestJson );
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            Account findAcount = accountService.findByEmail( transferRequestJson.getEmail() );

            log.info( "2: " + findAcount );
            if( findAcount == null) {
                throw new Exception("Can not find account " + transferRequestJson.getEmail() );
            }
            map.put("success", new Boolean(true) );
            map.put("transactions", Utility.toTransferResponseJson( findAcount.getTransferList() ) );

            log.info( "3: " + map );

            return new ResponseEntity<Map<String, Object>>( map, HttpStatus.OK);
        } catch ( Exception e ) {

            e.printStackTrace();
            map.put("success", new Boolean(false) );
            map.put("msg", e.getMessage() );
            return new ResponseEntity<Map<String, Object>>( map, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }


}
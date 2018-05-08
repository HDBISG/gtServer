package com.gtdollar.gtserver.bean;

import com.gtdollar.gtserver.model.Transfer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ok on 8/5/18.
 */
public class Utility {

    public static List<TransferResponseJson> toTransferResponseJson(List<Transfer> transferList) {

        if( transferList == null ) {
            return  null;
        }
        List<TransferResponseJson> transferResponseJsonList = new ArrayList<>();

        for( Transfer transfer: transferList ) {
            TransferResponseJson transferResponseJson = new TransferResponseJson( transfer );
            transferResponseJsonList.add( transferResponseJson );
        }

        return transferResponseJsonList;
    }
    static  DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static String formatDateTime( Date date ) {
        return fmt.format( date );
    }
}

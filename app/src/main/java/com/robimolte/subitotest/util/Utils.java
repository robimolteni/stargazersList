package com.robimolte.subitotest.util;

/**
 * Created by robimolte on 04/02/2017.
 */

public class Utils {


    public static boolean checkInputFields(String ownerRepo, String nameRepo)
    {
        if(ownerRepo == null || nameRepo == null)
            return false;
        if(ownerRepo.length() <= 0 || nameRepo.length() <= 0)
            return false;

        return true;
    }
}

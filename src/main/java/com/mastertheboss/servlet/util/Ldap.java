package com.mastertheboss.servlet.util;

import ca.teranet.csp.util.PropsBase;

public class Ldap {

    public String getPassword() {

        try {
            String userDN = "uid=csp_bt_super_user,cn=DEV,ou=CSP,ou=private-ldap,dc=teranet-private,dc=ca";
            return PropsBase.getInstance().getCachedLDAPPasswordByUserDN(userDN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

// run this command to execute main: mvn install
//                                   mvn exec:java -Dexec.mainClass="com.app.startup.Main"
package com.app.startup;

import com.app.integration.*;
import com.app.controller.*;
import com.app.view.*;

/**
 * Hello world!
 *
 */
public class Main {

    private Integration intgr;
    private Controller contr;
    private View view;

    /**
     * 
     */
    public static void main(String[] args) {
        this.intgr = new Integration();
        this.contr = new Controller();
        this.view = new View();
    }
}
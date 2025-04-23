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

    /**
     * 
     */
    public static void main(String[] args) {
        Integration intgr = new Integration();
        Controller contr = new Controller(intgr);
        View view = new View();
    }
}
// run this command to execute main: mvn install
 //                                   mvn exec:java -Dexec.mainClass="com.app.startup.Main"
package com.app.startup;

import com.app.integration.*;
import com.app.controller.*;
import com.app.view.*;
import com.app.util.*;

/**
 * The entry point of the application.
 * This class initializes the application's core components including the integration layer,
 * controller, and view. It is responsible for starting up the system.
  */
public class Main {

    /**
     * Launches the application by creating instances of the integration layer,
     * controller, and view. This is the starting point of the program.
     */
    public static void main(String[] args) {
        Integration intgr = new Integration();
        Controller contr = new Controller(intgr);
        contr.addLogger(new ConsoleLogger());
        contr.addLogger(new FileLogger());
        View view = new View(contr);
        view.viewCalls();
        view.viewCalls2();
    }
}

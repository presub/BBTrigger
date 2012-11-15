/** 
* GUILessApplication 
*
* A sample application that appears on the ribbon 
* but does not have any user interface. 
*/ 
package com.bb.trigger;

import net.rim.device.api.system.Application;

public final class GUILessApp extends Application
{ 
     private BackGroundApp backGroundApp; 
//     public static void main(String[] args) 
//     { 
//          GUILessApp theApp = new GUILessApp();
//          theApp.enterEventDispatcher(); 
//     }

     public GUILessApp()
     {
          //Creates and starts a new BackGroundApp thread.

          backGroundApp = new BackGroundApp();
          backGroundApp.start();
     }

     //The thread that will run in the background.
     private class BackGroundApp extends Thread
     {
          boolean stopThread = false;
          public synchronized void stop() 
          { 
               stopThread = true;
          }

          public void run() 
          {
               while (!stopThread) 
               { 
                    //You would perform your processing here.
                    //This sample just prints out a line 
                    //to the BlackBerry JDE Output Window
                    System.out.println("Application is running"); 

                    //Sleep for 5 seconds to prevent the
                    //application from running out of control
                    try 
                    { 
                         sleep(5000); 
                    } 
                    catch (Exception e)
                    { 
                         //Exception handling would go here. 
                    } 
               } 
          } 
     } 
     //Stop the thread on exit. 
     protected void onExit() 
     { 
          backGroundApp.stop(); 
     } 
}
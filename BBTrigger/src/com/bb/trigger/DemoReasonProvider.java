/*
 * DemoReasonProvider.java
 *
 * Copyright © 1998-2011 Research In Motion Ltd.
 * 
 * Note: For the sake of simplicity, this sample application may not leverage
 * resource bundles and resource strings.  However, it is STRONGLY recommended
 * that application developers make use of the localization features available
 * within the BlackBerry development platform to ensure a seamless application
 * experience across a variety of languages and geographies.  For more information
 * on localizing your application, please refer to the BlackBerry Java Development
 * Environment Development Guide associated with this release.
 */

package com.bb.trigger;

import net.rim.device.api.applicationcontrol.ApplicationPermissions;
import net.rim.device.api.applicationcontrol.ReasonProvider;

/**
 * This class implements the ReasonProvider interface in order to provide
 * detailed permission request messages for the user.
 * 
 * To test ReasonProvider functionality, when prompted, set the demo's 
 * application permissions to "prompt" and then run those tests.  When the
 * pop-up asking for permission appears, click "Details from the vendor..."
 * to view your messages.  The messages will only appear when access is 
 * being requested.
 * 
 */
public final class DemoReasonProvider implements ReasonProvider 
{    
   /**
    * @see net.rim.device.api.applicationcontrol.ReasonProvider#getMessage(int)
    */
    public String getMessage(int permissionID) 
    {        
        // General message for other permissions
        String message = "ReasonProviderDemo recieved permissionID: " + permissionID;
        
        // Set specific messages for specific permission IDs
        switch (permissionID) {
                
            case ApplicationPermissions.PERMISSION_INPUT_SIMULATION:
                message = "Sample message for PERMISSION_INPUT_SIMULATION"; break;
                    
            case ApplicationPermissions.PERMISSION_PHONE:
                message = "Sample message for PERMISSION_PHONE"; break;
            
            case ApplicationPermissions.PERMISSION_DEVICE_SETTINGS:
                message = "Sample message for PERMISSION_DEVICE_SETTINGS"; break;
            
            case ApplicationPermissions.PERMISSION_EMAIL:
                message = "Sample message for PERMISSION_EMAIL"; break;
        }
        
        return message;
    }
}

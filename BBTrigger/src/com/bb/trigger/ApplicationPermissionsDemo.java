/*
 * ApplicationPermissionsDemo.java
 *
 * Copyright � 1998-2011 Research In Motion Ltd.
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

import net.rim.blackberry.api.invoke.*;
import net.rim.blackberry.api.mail.*;
import net.rim.device.api.applicationcontrol.*;
import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;



/**
 * This sample demonstrates the ApplicationPermissions API. If the required
 * permissions for this application have been denied by the user, the
 * application will prompt for access to these resources. The ability to test
 * these capabilities is provided as part of the sample. This sample needs to be
 * run on a secure device or simulator. If using a simulator go to
 * Edit/Preferences/Simulator/General in the JDE and select
 * "Enable Device Security". You will also need to have the cod file generated
 * by this project signed with the Signature Tool. For more information on code
 * signing please refer to the BlackBerry Signature Tool Development Guide.
 */
public final class ApplicationPermissionsDemo extends UiApplication implements FieldChangeListener
{
    private ButtonField _eventInjectorButton;
    private ButtonField _phoneButton;
    private ButtonField _deviceSettingsButton;
    private ButtonField _emailButton;


    /**
     * Entry point for the application
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args)
    {
        ApplicationPermissionsDemo sample = new ApplicationPermissionsDemo();

        // Make the currently running thread the application's event
        // dispatch thread and begin processing events.
        sample.enterEventDispatcher();
    }


    /**
     * Creates a new ApplicationPermissionsDemo object
     */
    public ApplicationPermissionsDemo()
    {
        checkPermissions();
        showTestScreen();
    }


    /**
     * This method showcases the ability to check the current permissions for
     * the application. If the permissions are insufficient, the user will be
     * prompted to increase the level of permissions. You may want to restrict
     * permissions for the ApplicationPermissionsDemo.cod module beforehand in
     * order to demonstrate this sample effectively. This can be done in
     * Options/Advanced Options/Applications/(menu)Modules.Highlight
     * 'ApplicationPermissionsDemo' in the Modules list and select 'Edit
     * Permissions' from the menu.
     */
    private void checkPermissions()
    {
        // NOTE: This sample leverages the following permissions: 
        // --Event Injector
        // --Phone
        // --Device Settings
        // --Email
        // The sample demonstrates how these user defined permissions will
        // cause the respective tests to succeed or fail. Individual 
        // applications will require access to different permissions. 
        // Please review the Javadocs for the ApplicationPermissions class 
        // for a list of all available permissions
        // May 13, 2008: updated permissions by replacing deprecated constants.

        // Capture the current state of permissions and check against the requirements
        ApplicationPermissionsManager apm = ApplicationPermissionsManager.getInstance();
        ApplicationPermissions original = apm.getApplicationPermissions();

        // Set up and attach a reason provider
        DemoReasonProvider drp = new DemoReasonProvider();
        apm.addReasonProvider(ApplicationDescriptor.currentApplicationDescriptor(), drp);

        if(original.getPermission(ApplicationPermissions.PERMISSION_INPUT_SIMULATION) == ApplicationPermissions.VALUE_ALLOW &&
           original.getPermission(ApplicationPermissions.PERMISSION_PHONE) == ApplicationPermissions.VALUE_ALLOW &&
           original.getPermission(ApplicationPermissions.PERMISSION_DEVICE_SETTINGS) == ApplicationPermissions.VALUE_ALLOW &&
           original.getPermission(ApplicationPermissions.PERMISSION_EMAIL) == ApplicationPermissions.VALUE_ALLOW)
        {
            // All of the necessary permissions are currently available
            return;
        }

        // Create a permission request for each of the permissions your application
        // needs. Note that you do not want to list all of the possible permission
        // values since that provides little value for the application or the user.  
        // Please only request the permissions needed for your application.
        ApplicationPermissions permRequest = new ApplicationPermissions();
        permRequest.addPermission(ApplicationPermissions.PERMISSION_INPUT_SIMULATION);
        permRequest.addPermission(ApplicationPermissions.PERMISSION_PHONE);
        permRequest.addPermission(ApplicationPermissions.PERMISSION_DEVICE_SETTINGS);
        permRequest.addPermission(ApplicationPermissions.PERMISSION_EMAIL);

        boolean acceptance = ApplicationPermissionsManager.getInstance().invokePermissionsRequest(permRequest);

        if(acceptance)
        {
            // User has accepted all of the permissions
            return;
        }
        else
        {
            // The user has only accepted some or none of the permissions 
            // requested. In this sample, we will not perform any additional 
            // actions based on this information. However, there are several 
            // scenarios where this information could be used. For example,
            // if the user denied networking capabilities then the application 
            // could disable that functionality if it was not core to the 
            // operation of the application.
        }
    }


    /**
     * Shows the test screen to allow the user to exercise the application
     * permissions capabilities.
     */
    private void showTestScreen()
    {
        MainScreen screen = new MainScreen();
        screen.setTitle("Application Permissions Demo");

        if(_eventInjectorButton == null)
        {
            _eventInjectorButton = new ButtonField("Event Injector", ButtonField.NEVER_DIRTY | ButtonField.CONSUME_CLICK);
            _eventInjectorButton.setChangeListener(this);
        }

        if(_phoneButton == null)
        {
            _phoneButton = new ButtonField("Phone", ButtonField.NEVER_DIRTY | ButtonField.CONSUME_CLICK);
            _phoneButton.setChangeListener(this);
        }

        if(_deviceSettingsButton == null)
        {
            _deviceSettingsButton = new ButtonField("Device Settings", ButtonField.NEVER_DIRTY | ButtonField.CONSUME_CLICK);
            _deviceSettingsButton.setChangeListener(this);
        }

        if(_emailButton == null)
        {
            _emailButton = new ButtonField("Email", ButtonField.NEVER_DIRTY | ButtonField.CONSUME_CLICK);
            _emailButton.setChangeListener(this);
        }

        screen.add(_eventInjectorButton);
        screen.add(_phoneButton);
        screen.add(_deviceSettingsButton);
        screen.add(_emailButton);

        pushScreen(screen);
    }


    /**
     * Tests the EventInjector API
     */
    private void testEventInjector()
    {
        EventInjector.invokeEvent(new EventInjector.TrackwheelEvent(EventInjector.TrackwheelEvent.THUMB_ROLL_UP, 1, 1));
        EventInjector.invokeEvent(new EventInjector.TrackwheelEvent(EventInjector.TrackwheelEvent.THUMB_ROLL_DOWN, 1, 1));
    }


    /**
     * Tests the Phone API
     */
    private void testPhone()
    {
        Invoke.invokeApplication(Invoke.APP_TYPE_PHONE, new PhoneArguments(PhoneArguments.ARG_CALL, "555-555-5555"));
    }


    /**
     * Tests the device settings
     */
    private void testDeviceSettings()
    {
        Device.setDateTime(System.currentTimeMillis());
    }


    /**
     * Tests the email API
     */
    private void testEmail()
    {
        try
        {
            Transport.send(new Message());
        }
        catch(MessagingException e)
        {
            errorDialog("Transport.send(Message) threw " + e.toString());
        }

    }


    ///////////////////////////////////////////////////////////
    ///     FieldChangeListener Interface Implementation    ///
    ///////////////////////////////////////////////////////////
    /**
     * @see net.rim.device.api.ui.FieldChangeListener#fieldChanged(Field,int)
     */
    public void fieldChanged(Field field, int context)
    {
        try
        {
            if(field.equals(_eventInjectorButton))
            {
                testEventInjector();
            }
            else if(field.equals(_phoneButton))
            {
                testPhone();
            }
            else if(field.equals(_deviceSettingsButton))
            {
                testDeviceSettings();
            }
            else if(field.equals(_emailButton))
            {
                testEmail();
            }

            Dialog.inform("Test successful");
        }
        catch(ControlledAccessException e)
        {
            // Do not have access to the API.  Indicate as such.
            errorDialog(e.toString());
        }
    }


    /**
     * Presents a dialog to the user with a given message
     * 
     * @param message The text to display
     */
    public static void errorDialog(final String message)
    {
        UiApplication.getUiApplication().invokeLater(new Runnable()
        {
            public void run()
            {
                Dialog.alert(message);
            }
        });
    }
}

package com.bb.trigger.utils;

import net.rim.device.api.applicationcontrol.ApplicationPermissions;
import net.rim.device.api.applicationcontrol.ApplicationPermissionsManager;

public class PermissionManager {

	private static int[] permissionKeys = new int[] {
			ApplicationPermissions.PERMISSION_INPUT_SIMULATION,
			ApplicationPermissions.PERMISSION_PHONE,
			ApplicationPermissions.PERMISSION_DEVICE_SETTINGS,
			ApplicationPermissions.PERMISSION_EMAIL,
			ApplicationPermissions.PERMISSION_BLUETOOTH,
			ApplicationPermissions.PERMISSION_DEVICE_SETTINGS,
			ApplicationPermissions.PERMISSION_APPLICATION_MANAGEMENT,
			ApplicationPermissions.PERMISSION_DISPLAY_LOCKED,
			ApplicationPermissions.PERMISSION_INTERNET,
			ApplicationPermissions.PERMISSION_FILE_API };

	/**
	 * This method showcases the ability to check the current permissions for
	 * the application. If the permissions are insufficient, the user will be
	 * prompted to increase the level of permissions. You may want to restrict
	 * permissions for the ApplicationPermissionsDemo.cod module beforehand in
	 * order to demonstrate this sample effectively. This can be done in
	 * Options/Advanced Options/Applications/(menu)Modules.Highlight
	 * 'ApplicationPermissionsDemo' in the Modules list and select 'Edit
	 * Permissions' from the menu.
	 * @return 
	 */
	public static boolean checkPermissions() {
		// Capture the current state of permissions and check against the
		// requirements
		ApplicationPermissionsManager apm = ApplicationPermissionsManager
				.getInstance();
		ApplicationPermissions original = apm.getApplicationPermissions();
		boolean hasPermissions = true;
		for (int i = 0; i < permissionKeys.length; i++) {
			if (original.getPermission(permissionKeys[i]) != ApplicationPermissions.VALUE_ALLOW) {
				hasPermissions = false;
				break;
			}
		}
		if (hasPermissions) {
			return true;
		}

		// Create a permission request for each of the permissions 		
		ApplicationPermissions permRequest = new ApplicationPermissions();
		for (int i = 0; i < permissionKeys.length; i++) {
			permRequest.addPermission(permissionKeys[i]);
		}
		return ApplicationPermissionsManager.getInstance()
				.invokePermissionsRequest(permRequest);

		 
	}
}

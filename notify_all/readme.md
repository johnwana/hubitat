# Notify All
- Send notifications to all your devices using a single virtual device.
- Add and remove new notification devices without needing to change all your rules

## Usage
- Once installed, choose the `Notify All` device to send your notifications to. It will in turn send notifications to the devices you chose in the app
- Whenever you get a new device, once it's set up with Hubitat you can add it to the list of devices to send to in the Notify All app

## Installation
Install both the app and the driver
### Import the app code
- Go to `Apps Code` from the app menu and press `New App`
- Press `Import`
- Type `https://raw.githubusercontent.com/johnwana/hubitat/master/notify_all/notify_all_app.groovy` in the URL textbox
- Press `Save`
### Import the driver code
- Go to `Drivers Code` from the app menu and press `New Driver`
- Press `Import`
- Type `https://raw.githubusercontent.com/johnwana/hubitat/master/notify_all/notify_all_device.groovy` in the URL textbox
- Press `Save`
### Add the app
- Go to `Apps` from the app menu and press `Add User App`
- Choose `Notify All`
- Under `Notify these devices`, choose which devices you want to notify together
- Press `Done`

This will also create a new device called Notify All which you will use to send notifications.

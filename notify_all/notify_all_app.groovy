definition(
    name:"Notify All",
    namespace: "NotifyAll",
    author: "John Wana",
    description: "Send notifications to all your devices together",
    iconUrl: "",
    iconX2Url: "",
    iconX3Url: "",
	importUrl: "https://raw.githubusercontent.com/johnwana/hubitat/master/notify_all/notify_all_app.groovy",
)

preferences {
    section("Devices") {
        input "notificationDevices", "capability.notification", title: "Notify these devices", multiple:true
    }
    section("App options") {
        input name: "enableDebug", type: "bool", title: "Enable debug logging", defaultValue: true
    }
}

def installed() {
    logDebug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    logDebug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    ensureNotifyAllDevice();
    subscribe(notifyAllDevice, "deviceNotification", notificationHandler)
}

def ensureNotifyAllDevice() {
    def driver_dni = "NotifyAllDevice"
    def driver_name = "Notify All"
    def driver_namespace = "NotifyAll"
    def device = getChildDevice(driver_dni);
    if (!device) {
        logDebug("Unable to find NotifyAll device");
        device = addChildDevice(driver_namespace, driver_name, driver_dni, null, null)
        logDebug("Created NotifyAll device: ${device}")
    } else {
        logDebug("Found NotifyAll device: ${device}")
    }
}

def deviceNotification(evt) {
    logDebug "Handling event: $evt"
    notificationDevices.each { notificationDevice -> 
        log.info "Sending '$evt' to ${notificationDevice}"
        notificationDevice.deviceNotification(evt)
    }
}

def logDebug(str) {
    if (enableDebug) {
        log.debug(str)
    }
}
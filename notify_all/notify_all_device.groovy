metadata {
	definition (name: "Notify All", namespace: "NotifyAll", author: "John Wana", importUrl: "https://raw.githubusercontent.com/johnwana/hubitat/master/notify_all/notify_all_device.groovy") {
    capability "Notification"
	}
}

def deviceNotification(message) {
  parent.deviceNotification(message);
}
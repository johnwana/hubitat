metadata {
  // TODO: fill importUrl
	definition (name: "Notify All", namespace: "NotifyAll", author: "John Wana", importUrl: "https://raw.githubusercontent.com/johnwana") {
    capability "Notification"
	}
}

def deviceNotification(message) {
  parent.deviceNotification(message);
}
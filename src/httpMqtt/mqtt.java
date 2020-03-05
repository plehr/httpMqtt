package httpMqtt;

import org.eclipse.paho.client.mqttv3.*;

public class mqtt {
	public static int QOS = 1;
	private MqttClient mClient;

	private final String broker, user, passwd;

	public mqtt(String broker, String user, String passwd) {
		this.broker = broker;
		this.user = user;
		this.passwd = passwd;
	}

	public void connect() throws MqttException {
		mClient = new MqttClient(broker, "HTTPMqtt - " + MqttClient.generateClientId());
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setUserName(this.user);
		connOpts.setPassword(this.passwd.toCharArray());
		mClient.connect(connOpts);
	}

	public void send(String key, String value) throws MqttPersistenceException, MqttException {
		MqttMessage mmsg = new MqttMessage(value.getBytes());
		mmsg.setQos(mqtt.QOS);
		mClient.publish("http/" + key, mmsg);
	}

	public void disconnect() throws MqttException {
		mClient.disconnect();
	}
}

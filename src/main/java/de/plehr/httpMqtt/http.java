package de.plehr.httpMqtt;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class http {

	@RequestMapping("/api/alert")
	@ResponseBody
	public String index(@RequestParam() Map<String, String> reqParam,
			@RequestParam(required = false, defaultValue = "_") String key) {
		mqtt mq = new mqtt(System.getenv("uri"), System.getenv("user"), System.getenv("passwd"));

		if (new String(key).equals(System.getenv("key")))
			try {
				reqParam.remove("key");
				mq.connect();
				for (String e : reqParam.keySet())
					mq.send(e, reqParam.get(e));
				mq.disconnect();
			} catch (MqttException e) {
				e.printStackTrace();
			}
		return "Thanks!";
	}
}

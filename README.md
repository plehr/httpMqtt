# httpMqtt

## Enviroment variables:
```
uri=<example: ssl://this.host.tld:1234>
user=<example: myusername>
passwd=<example: heyPasswd>
key=<exaple: topSecret>
```

## Call:

https://other.host.tld/api/alert?key=topSecret&key=value&moreKey=moreValues

## MQTT

On MQTT you see:

```
http/key -> value
http/moreKey -> moreValues
```
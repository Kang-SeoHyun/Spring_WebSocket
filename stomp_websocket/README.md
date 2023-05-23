# websocket-chat-server
## 🍃 Stomp 🍃
> websocket의 프로세스를 좀 더 고도화하고 메세징에 좀 더 최적화된 방식을 구현하기 위해 적용

특징 📝 :
* stomp는 메세징 전송을 효율적으로 하기 위해 나온 프로토콜
* 기본적으로 pub/sub 구조로 되어있음.
	* 메세지를 발송하고, 메세지를 받아 처리하는 부분이 확실히 정해져 있다.
	* 때문에 명확하게 인지하고 개발할 수 있다.
* 통신 메세지의 헤더에 값을 세팅할 수 있어 헤더 값을 기반으로 통신 시 인증처리 구현 가능

```
pub/sub 이란❓
메세지를 공급하는 주체와 소비하는 주체를 분리하여 제공하는 메세징 방법.
```
우체통📮 = topic, 집배원🕊 = publisher, 구독자📬 = subscriber
```
1. 채팅방을 생성한다.
	* pub/sub 구현을 위한 topic이 하나 생성된다.
2. 채팅방에 입장한다.
	* topic을 구독한다.
3. 채팅방에서 메세지를 보내고 받는다.
	* 해당 topic으로 메세지를 발송하거나(pub) 메세지를 받는다.(sub)
```
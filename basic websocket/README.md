## 🥊 http통신 VS socket 통신 🥊

http통신
* client의 요청이 있을 때만 server가 응답하고 연결을 종료하는 단방향 통신
* client가 server에 접속해 콘텐츠를 요청하고 결과를 받아 소비하는 구조의 서비스에 사용

socket통신
* server와 client가 지속적으로 연결을 유지하는 양방향 통신
* 채팅 같은 실시간성을 요구하는 서비스에 사용

## 🖥 Websocket 🖥
> 기존 단방향 HTTP 프로토콜과 호환되어 양방향 통신을 제공하기 위해 개발된 프로토콜

* 일반 socket통신과 달리 HTTP 80 Port를 이용하므로 방화벽에 제약이 없다.
* 접속까지는 HTTP 프로토콜을 이용하고 그 이후의 통신은 자체적인 Websocket 프로토콜로 통신한다.

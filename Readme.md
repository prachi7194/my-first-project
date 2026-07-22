For SSE demo:
Post:
curl -N http://localhost:8080/orders/101/stream\nevent:order-update\ndata:{"orderId":"102","status":"Preparing"}

Get:
curl -N http://localhost:8080/orders/101/stream

For Shortpolling demo:
curl -X POST \
-H "Content-Type: text/plain" \
-d "Preparing" \
http://localhost:8080/short/orders/101/status


Get
curl http://localhost:8080/short/orders/101/status

For long Polling demo:

curl -X POST \
-H "Content-Type: text/plain" \
-d "Preparing" \
http://localhost:8080/long/orders/101/status


Get
curl http://localhost:8080/long/orders/101/status
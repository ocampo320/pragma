# Reto prgma
 
En este poyecto se esta exponiendo un servicio para registrar un usuario.

~~~
curl --location --request POST 'localhost:8185/api/pragma/create' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"carlos",
"lastName":"Lopez",
"phoneNumber":"22222",
"address":"cr 4 este 54 b14",
"email":"telecentro.lasierra@gmail.com",
"password":"Deivi3npc7odo5su2*"
}'
~~~


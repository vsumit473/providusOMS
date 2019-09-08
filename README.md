# providusOMS
An API microservice for a order management system.

To Access Database
URL : http://ec2-18-216-46-22.us-east-2.compute.amazonaws.com:9090/h2-console

To Access API System 
URL: http://ec2-18-216-46-22.us-east-2.compute.amazonaws.com:9090/

NOTE : The API is Swagger UI enabled, all the below APIs can be accessed on a browser from the above URL

================================
Order Creation:                |
================================

API  : /providus/order 
Type : POST
Body : {
  "currency": "INR",
  "description": "Laptop",
  "dueDate": "2019-09-08T09:33:22.295Z",
  "orderAmount": 60000,
  "products": [
    {
      "productName": "Lenovo"
    }
  ]
}
==================================
Order Status Update:             |
==================================
API  : /providus/order/status/{id}
Type : PUT
Parameters : id=1, status=COMPLETED

===================================
Retrieve over due orders          |
===================================
API  : /providus/order 
Type : GET
Parameters : filter=true //fetch only over due orders, filter=false //fetch all orders

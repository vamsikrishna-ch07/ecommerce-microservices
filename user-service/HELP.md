# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.ecommerce.user-service' is invalid and this project uses 'com.ecommerce.userservice' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.4/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.4/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.4/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/reference/spring-cloud-netflix.html#_service_discovery_eureka_clients)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.5.4/reference/actuator/index.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.4/reference/using/devtools.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

=======
left to create:# Microservices Overview
🆕 Product Service	Handles products (CRUD: add, update, delete, view)
🆕 Inventory Service	Manages stock for each product
🆕 Cart Service	Add/remove items for a user's cart
🆕 Order Service  Places an order from cart


✅ Next Step (Step-by-Step)
🔹 Step 1: Create Product Service
Responsibilities:

Add product

Get product list

Get product by ID

Update / delete product

Tables: product(id, name, description, price)

Register with Eureka and get configs from Config Server.

🔹 Step 2: Create Inventory Service
Responsibilities:

Track stock for products

Update stock after order

Tables: inventory(id, product_id, available_quantity)

Communicates with Product Service (via RestTemplate or Feign)

🔹 Step 3: Create Cart Service
Responsibilities:

Add product to user's cart

Remove product

View cart

Tables: cart(id, user_id), cart_items(id, cart_id, product_id, quantity)

🔹 Step 4: Create Order Service
Responsibilities:

Place order

Reduce inventory

Store order data

Tables: order(id, user_id, order_date, total_amount)
order_items(order_id, product_id, quantity, price)
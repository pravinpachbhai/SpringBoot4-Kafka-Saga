# SpringBoot4-Kafka-Saga

# Because of the limited resources I am creating all the service in one project

# Please create different microservices for each service below and related database. Clear responsibilities, APIs, and database design per service.
<br/>
1 - UserService<br/>
2 - OrderService<br/>
3 - InventoryService<br/>
4 - PaymentService<br/>
5 - ShippingService<br/>
6 - EmailNotificationService<br/>
<br/><br/>
<img src="src/main/resources/static/Diagram.jpg" alt="Description" width="800">


| Header 1 | Header 2 | Header 3 |
| -------- | -------- | -------- |
| Row 1, Col 1 | Row 1, Col 2 | Row 1, Col 3 |
| Row 2, Col 1 | Row 2, Col 2 | Row 2, Col 3 |

Service	DB	Key Responsibility
UserService	user_db	User management
OrderService	order_db	Orders
InventoryService	inventory_db	Stock
PaymentService	payment_db	Payments
ShippingService	shipping_db	Delivery
EmailNotificationService	notification_db	Notifications

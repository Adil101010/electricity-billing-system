# ⚡ Electricity Billing System

A Spring Boot-based backend system to manage electricity consumer data, meter readings, and billing. This project provides REST APIs for bill generation, payment tracking, and CRUD operations with integrated Swagger documentation.

---

## 🚀 Features

- ✅ Add new consumer
- ✅ Create, update, delete electricity bills
- ✅ Mark bills as paid
- ✅ View total due by consumer
- ✅ View paid/unpaid bills
- ✅ Integrated Swagger UI for API testing

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot (3.x)
- Spring Data JPA
- MySQL
- Swagger (OpenAPI)
- Maven

---

## 📁 Project Structure

electricity-billing-system/
└── electricity-billing/
├── controller/
├── model/
├── repository/
├── service/
├── ElectricityBillingApplication.java
└── resources/
└── application.properties

yaml
Copy
Edit

---

## ⚙️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/Adil101010/electricity-billing-system.git
cd electricity-billing-system/electricity-billing
2. Configure MySQL
In src/main/resources/application.properties, set your DB info:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
3. Run the Project
bash
Copy
Edit
mvn spring-boot:run
Or run ElectricityBillingApplication.java directly from your IDE.

🔗 Swagger API Documentation
Once running, open your browser at:

bash
Copy
Edit
http://localhost:8080/swagger-ui/index.html
📬 Key API Endpoints
Method	Endpoint	Description
POST	/api/consumers	Add new consumer
GET	/api/consumers	Get all consumers
POST	/api/bills	Create new bill
GET	/api/bills	Get all bills
GET	/api/bills/{id}	Get bill by ID
PUT	/api/bills/{id}	Update bill
DELETE	/api/bills/{id}	Delete bill
PUT	/api/bills/{id}/pay	Mark bill as paid
GET	/api/bills/paid	Get all paid bills
GET	/api/bills/unpaid	Get all unpaid bills
GET	/api/bills/consumer/{consumerId}	Bills of specific consumer
GET	/api/bills/total-due/{consumerId}	Total due for consumer

👨‍💻 Author
Adil
GitHub: Adil101010

📃 License
This project is licensed under the MIT License.

yaml
Copy
Edit

---

### ✅ Next Steps:

1. Replace your current `README.md` with this updated one.
2. Open terminal in your project folder and run:

```bash
git add README.md
git commit -m "📄 Finalized professional README file"
git push
# salon-booking-application

Salon Appointment Booking Full Stack Project With Microservices Architecture:-
------------------------------------------------------------------------------
What Technology You Will Learn:
--------------------------------
Microservice Architecture:
>Develop scalable systems with independent services.

Backend:
--------
Spring Boot: Robust backend services.
Keycloak: Secure authentication and authorization.
JWT: Token-based security.
MySQL: Efficient data management.
RabbitMQ: Event-driven communication.
WebSocket: Real-time notifications.

DevOps:
-------
Docker: Containerization for seamless deployments.

Frontend:
React for building dynamic user interfaces,
TailwindCSS for beautiful, custom designs,
Redux for efficient state management,
Material-UI (MUI) for elegant components
Formik for seamless form handling and validation.

Payment Gateway
Razorpay

>>Tools & Technology You Need to Install
	Tools & Technology You Need to Install
	
IntelliJ IDEA
	IDE for efficient backend development.
MySQL
	Relational database for managing application data.
VS Code
	Lightweight and powerful editor for frontend development.
Docker
	Containerization platform for running and managing services.
	
>>🚀 Build Microservices 🛠️<<

	👤 User Service
	
	🔐 Auth Endpoints

>>📝 POST /auth/signup
	📝 Description: Registers a new user with the provided signup details.
	📥 Request Body:
	🆕 SignupDto (contains user registration details).
	📤 Response:
	🟢 Success message: "User created successfully."
	📄 Authentication response object.
	
>>🔑 POST /auth/login
	📝 Description: Logs in a user using their email and password.
	📥 Request Body:
	📧 LoginDto (contains email and password).
	📤 Response:
	🟢 Success message: "User logged in successfully."
	📄 Authentication response object.
	
>>🔄 GET /auth/access-token/refresh-token/{refreshToken}
	📝 Description: Generates a new access token using a valid refresh token.
	📥 Parameters:
	🔑 refreshToken (PathVariable).
	📤 Response:
	🟢 Success message: "Refresh token received successfully."
	📄 Authentication response object.
	
>>👥 User Endpoints
>👤 GET /api/users/profile
	📝 Description: Retrieves the user profile based on the JWT token.
	📥 Request Header:
	🔑 Authorization (JWT token).
	📤 Response:
	📄 UserDTO containing the user's profile information.
	✅ HTTP Status:
	🟢 200 OK on success.
	
>🔍 GET /api/users/{userId}
	📝 Description: Retrieves user details based on their ID.
	📥 Path Parameter:
	🆔 userId (ID of the user to retrieve).
	📤 Response:
	📄 UserDTO containing the user's details.
	✅ HTTP Status:
	🟢 200 OK on success.
	❌ Throws a UserException if the user is not found.
>>💇 Salon Service
  Base URL: /api/salons
  
>>1️⃣ Create Salon
🔹 POST /api/salons
📝 Description: Creates a new salon for the authenticated user.
🔑 Authorization:
Header: "Authorization" → JWT token
📥 Request Body:
SalonDTO → Details of the salon to be created.
📤 Response:
Status: 201 Created
Body: SalonDTO → Details of the newly created salon.
>>2️⃣ Update Salon
🔹 PUT /api/salons/{salonId}
📝 Description: Updates an existing salon based on the given salon ID.
🔑 Path Parameter:
salonId → ID of the salon to update.
📥 Request Body:
Salon → Updated details of the salon.
📤 Response:
Status: 200 OK
Body: SalonDTO → Updated details of the salon.
>>3️⃣ Get All Salons
🔹 GET /api/salons
📝 Description: Retrieves a list of all salons.
📤 Response:
Status: 200 OK
Body: List<SalonDTO> → A list of all salons with owner details.
>>4️⃣ Get Salon By ID
🔹 GET /api/salons/{salonId}
📝 Description: Retrieves the details of a salon by its ID.
🔑 Path Parameter:
salonId → ID of the salon.
📤 Response:
Status: 200 OK
Body: SalonDTO → Details of the specified salon.
❌ Error Handling:
Throws an exception if the salon does not exist.
>>5️⃣ Search Salon By City
🔹 GET /api/salons/search
📝 Description: Searches for salons in a specific city.
🔑 Query Parameter:
city → City name to search salons.
📤 Response:
Status: 200 OK
Body: List<SalonDTO> → A list of salons matching the city criteria.
>>6️⃣ Get Salon By Owner
🔹 GET /api/salons/owner
📝 Description: Retrieves the salon owned by the authenticated user.
🔑 Authorization:
📤 Response:
🎯 Highlights
Each endpoint is carefully integrated with SalonService and UserFeignClient to ensure efficient data flow and mapping.
Custom exceptions like UserException handle user-related errors gracefully.
Simplified DTO mapping via SalonMapper.

📚 Note:
Make sure the Authorization header contains a valid JWT token for endpoints requiring user authentication. 💡

🌟 Category Microservice API Documentation
===============================================
Base URL: /api/categories
Owner-Specific Base URL: /api/categories/salon-owner
1>>️⃣ Get All Categories
🔹 GET /api/categories
📝 Description: Fetches all available categories.
📤 Response:
>>2️⃣ Get Categories by Salon ID
🔹 GET /api/categories/salon/{id}
📝 Description: Retrieves categories associated with a specific salon.
🔑 Path Parameter:
🔑 Header Parameter:
📤 Response:
🔗 Feign Clients:
>>3️⃣ Get Category by ID
🔹 GET /api/categories/{id}
📝 Description: Retrieves a single category by its ID.
🔑 Path Parameter:
📤 Response:
>>4️⃣ Delete Category by ID
🔹 DELETE /api/categories/{id}
📝 Description: Deletes a category by its ID.
🔑 Path Parameter:
📤 Response:
>>5️⃣ Create Category (Salon Owner)
🔹 POST /api/categories/salon-owner
📝 Description: Allows a salon owner to create a new category for their salon.
🔑 Header Parameter:
📥 Request Body:
📤 Response:
🔗 Feign Clients:
🎯 Highlights

Role-Specific Endpoints:Separate APIs for all users and salon owners.
Integrated Feign Clients:
Comprehensive Error Handling:
Enhanced Security:JWT-based authorization ensures secure access to salon-owner-specific features.

📚 Note
Ensure that JWT tokens are passed in the "Authorization" header for both salon-owner-specific and category-fetching operations. This guarantees proper authentication and data access.

🌟 Service Offering Microservice
=======================================
Base URL: /api/service-offering
Owner-Specific Base URL: /api/service-offering/salon-owner
>>1️⃣ Get Services by Salon ID
🔹 GET /api/service-offering/salon/{salonId}
📝 Description: Retrieves all services offered by a specific salon, with an optional filter by category.
🔑 Path Parameter:
🔑 Query Parameter (Optional):
📤 Response:
>>2️⃣ Get Service by ID
🔹 GET /api/service-offering/{serviceId}>>
📝 Description: Retrieves details of a specific service by its ID.
🔑 Path Parameter:
📤 Response:
❌ Error Handling:
>>3️⃣ Get Services by Multiple IDs
🔹 GET /api/service-offering/list/{ids}
📝 Description: Retrieves details of multiple services by their IDs.
🔑 Path Parameter:
📤 Response:
>>4️⃣ Create Service (Salon Owner)
🔹 POST /api/service-offering/salon-owner
📝 Description: Allows a salon owner to create a new service under their salon.
🔑 Authorization:
📥 Request Body:
📤 Response:
🔗 Feign Clients:
>>5️⃣ Update Service (Salon Owner)
🔹 PUT /api/service-offering/salon-owner/{serviceId}
📝 Description: Allows a salon owner to update an existing service.
🔑 Path Parameter:
📥 Request Body:
📤 Response:
🎯 Highlights
Service Segmentation:Separate endpoints for all users and salon owners.
Integrated Feign Clients:
Error Handling:Custom exceptions and status codes provide clear responses for invalid requests.
Flexibility:Query parameter support enables dynamic filtering for services.
📚 Note
Ensure proper JWT tokens are provided in the Authorization header for all salon-owner-specific operations.

🌟 Booking Microservice API Documentation
================================================
Base URL: /api/bookings
>>1️⃣ Create a Booking
🔹 POST /api/bookings
📝 Description: Creates a new booking for a salon and generates a payment link.
🔑 Header Parameters:
🔑 Query Parameters:
📥 Request Body:
📤 Response:
🔗 Feign Clients:
>>2️⃣ Get All Bookings for a Customer
🔹 GET /api/bookings/customer
📝 Description: Retrieves all bookings associated with a customer.
🔑 Header Parameters:
📤 Response:
🔗 Feign Clients:
>>3️⃣ Get All Bookings for a Salon
🔹 GET /api/bookings/salon
📝 Description: Retrieves all bookings for a salon owned by the authenticated user.
🔑 Header Parameters:
📤 Response:
🔗 Feign Clients:
>>4️⃣ Get a Salon Report
🔹 GET /api/bookings/report
📝 Description: Retrieves a report of all bookings for the salon owned by the authenticated user.
🔑 Header Parameters:
📤 Response:
>>5️⃣ Get Bookings by Date
🔹 GET /api/bookings/slots/salon/{salonId}/date/{date}
📝 Description: Retrieves booked slots for a salon on a specific date.
🔑 Path Parameters:
🔑 Header Parameters:
📤 Response:
>>6️⃣ Get a Booking by ID
🔹 GET /api/bookings/{bookingId}
📝 Description: Retrieves details of a booking by its ID.
🔑 Path Parameter:
📤 Response:
7>>️⃣ Update Booking Status
🔹 PUT /api/bookings/{bookingId}/status
📝 Description: Updates the status of a booking (e.g., CONFIRMED, CANCELLED).
🔑 Path Parameter:
🔑 Query Parameter:
📤 Response:
🎯 Highlights
Role-Specific Endpoints:
Integrated Feign Clients:
Error Handling:
Enhanced Security:
Flexible Bookings Management:

🌟 Payment Microservice API Documentation
=============================================
Base URL: /api/payments
The Payment Controller handles APIs related to payment processing, including creating payment links, retrieving payment orders, and proceeding with payments.
Create Payment Link
POST /create
Creates a payment link for the specified booking using the given payment method.
Headers
Authorization: Bearer token of the user (String) (Required)
Request Body
BookingDTO: The details of the booking for which payment is being initiated.
Query Parameters
paymentMethod: The payment method to use (e.g., CREDIT_CARD, DEBIT_CARD, UPI, etc.)

Responses
200 OK: Returns the payment link details.
400 Bad Request: If required parameters are missing or invalid.
500 Internal Server Error: If an error occurs while creating the payment link.
Get Payment Order by ID
GET /{paymentOrderId}
Fetches a payment order by its unique ID.
Path Parameters
paymentOrderId: The ID of the payment order (Long) (Required)

Responses
200 OK: Returns the payment order details.
404 Not Found: If the payment order with the specified ID does not exist.
Proceed Payment
PATCH /proceed
Processes a payment for the specified payment order.
Query Parameters
paymentId: The unique ID of the payment made by the user (String) (Required)
paymentLinkId: The unique ID of the payment link (String) (Required)

Responses
200 OK: Returns true if the payment was processed successfully.
400 Bad Request: If the payment ID or link ID is invalid.
500 Internal Server Error: If an error occurs while processing the payment.
Exceptions and Error Handling
UserException
Thrown when there is an issue with user authentication or user-related data.
RazorpayException
Thrown for issues related to Razorpay integration, such as link creation failures.

General Error Responses
400 Bad Request: For invalid input or missing data.
500 Internal Server Error: For any unexpected server-side errors.
Dependencies and Notes
The controller relies on the following services:
Supported payment methods include Razorpay integrations.
Setup Project On Local Machine
-----------------------------------------------------------------
Steps to run frontend
npm i
npm start
Backend Setup
run all microservices
run keycloak server(user need to install docker for this)
Install Docker
​
Once keycloack setup is completed you can login, register on frontend and check all the functionality






What You Will Learn

🛠️Microservices Architecture
-----------------------------------

Learn to design scalable, modular systems with independent services for flexibility and reliability.


💻Backend Development

🌟 Spring Boot: Build powerful backend APIs and microservices.
🔒 Keycloak: Implement secure authentication and authorization.
🔑 JWT: Manage token-based security protocols.
🗄️ MySQL: Store and manage data efficiently.
⚡RabbitMQ: Enable real-time, event-driven communication.
🔔 WebSocket: Deliver real-time notifications seamlessly.


🎨Frontend Development

⚛️ React: Create responsive and dynamic user interfaces.
📊 Redux: Manage application state with ease.
📝 Formik: Build and validate robust forms.
🔗 Axios: Integrate APIs with clean and efficient requests.


⚙️DevOps Essentials

🐳Docker: Simplify development and deployment with containerized applications.


💵Payment Integration

Implement secure and reliable payment gateways using Razorpay and Stripe.


📝 Review Service
DOCUMENTATION LINK
https://documenter.getpostman.com/view/37320664/2sB2qi7coT

Base URL: https://reviewservice-to9o.onrender.com/api/v1/reviews

🔹 Get All Reviews
GET /reviews/

🔹 Get Review by ID
GET /reviews/{bookId}

🔹 Delete Review by ID
DELETE /reviews/{bookId}

🔹 Create a Review
POST /reviews

Request Body:

json
Copy code
{
  "bookId": "book_id_here",
  "author": "Reviewer Name",
  "subject": "Review Subject",
  "content": "This book was amazing!"
}
🔹 Update a Review
PUT /reviews/{bookId}

Request Body:

json
Copy code
{
  "bookId": "book_id_here",
  "author": "Updated Reviewer",
  "subject": "Updated Subject",
  "content": "Updated content of the review."
}

User Service

/users/register → store user in DB with hashed password

Stores role (like USER / ADMIN).

Auth Service

/auth/login → validates credentials using DB (later via User Service integration).

Issues JWT token.
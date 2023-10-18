# Opdracht
## "JWT"
1. Open oefenproject in IntelliJ
2. Configureer application.properties
3. Maak database aan in PostgreSQL(of MySQL)
4. Run project
5. Maak nieuwe user aan (via Postman)
6. Login met nieuwe user (via Postman)
7. Kopieer JSON webtoken(JWT) uit response header
8. Maak Postman request voor endpoint‘/hello’
   1. Authorisatietype ‘Bearertoken’ en paste token
9. Verander de token levensduur naar 1 minuut en test dit
10. Voeg een GET method ‘/users’ toe zodat iemand met ADMIN rechten alle gebruikers kan opvragen 
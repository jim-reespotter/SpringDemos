This demonstrates OAuth security...

This app knows about several different OAuth IdPs - Google, facebook, MS

Login page (/, /login)
- anonymously accessible
- contains links for each IdP
- links start oauth authentication with respective IdPs
- default page to be redirected to if you haven't got access to other pages

Content page - shows OAuth claims - only accessible to auth'd 
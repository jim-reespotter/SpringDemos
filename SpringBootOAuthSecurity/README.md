This demonstrates OAuth security...

This app knows about several different OAuth IdPs - Google, facebook, MS

Login page (/, /login)
- anonymously accessible
- contains links for each IdP
- links start oauth authentication with respective IdPs
- default page to be redirected to if you haven't got access to other pages

What works, what doesnt:
Works:
- login page - its got 3 auth links (fb, Google, MS) - hard coded, fb + gogole work, haven't confugured MS yet.
- content page shows logout button (needs POST - CSRF) - logs out OK
- Authentication:
- success URL needs to be set (to /content) - OK
Needs work:
- MS auth
- error page -> login page
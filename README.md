# REST API for the Northwind Database
## Project Overview
The purpose of this project was to create a REST API for the Northwind Database using Spring Boot and Hibernate. 
The project currently only has endpoints for the Category, Employee and Customer entities.

## Endpoints
### Categories
#### Categories
Get a list of all categories.  
`/categories`

#### Category information
Get more specific information about a particular category.  
`/categories/{name}`

#### Products by category
Get all products in a specific category.  
`/categories/{name}/products`

### Customers
#### Customers
Get all customers.  
`/customers`

#### Customer by name
Get a specific customer by name (case sensitive).  
`/customers?contactName={name}`

#### Customer contact titles
Get a list of all customer contact titles.  
`/customers/title`

#### Customers by contact title
Get a list of customers with the specified contact title (case-insensitive).
`/customers/title?contactTitle={title}`

#### Customers by location
Get a list of customers by location (at least one parameter required, case-insensitive).  
`/customers/location?region={region}&country={country}&city={city}`

### Employees
#### Employees
Get a list of all employees.  
`/employees`

#### Employee by name
Get a specific employee by name (case-sensitive).  
`/employees?name={name}`

#### Employee contact titles
Get a list of all employee contact titles.  
`/employees/title`

#### Employees by contact title
Get a list of employees with the specified contact title (case-insensitive).  
`/employees/title?contactTitle={title}`

#### Employees by location
Get a list of employees by location (at least one parameter required, case-insensitive).  
`/employees/location?region={region}&country={country}&city={city}`

#### Employees hired before/after specified date(s)
Get a list of employees hired before/after the specified date(s). The date should be in the format YYYY-MM-DD. At least 
one parameter required.  
`/employees/hired?lowerBound={date}&upperBound={date}`

## Future work
Currently, the REST API only has endpoints for three entities, so next steps would be to create controllers for the 
rest of the entities. Additionally, some information is filtered out, so it could be worth creating a second API to 
allow for access to all the data. Finally, the project has no unit tests as it was intended to be an exercise to learn 
about REST APIs - the testing will come later!